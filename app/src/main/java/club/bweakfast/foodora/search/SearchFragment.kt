package club.bweakfast.foodora.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R
import club.bweakfast.foodora.recipe.Recipe
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.util.onError
import club.bweakfast.foodora.util.showView
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.layout_empty_view.*
import java.io.InterruptedIOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val ARG_QUERY = "query"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    private val subscriptions: CompositeDisposable = CompositeDisposable()
    private lateinit var adapter: RecipesAdapter
    private val queryEmptyList = listOf(Recipe(-1, emptyList(), "", -1, -1, -1, -1, ""))

    @Suppress("MemberVisibilityCanBePrivate")
    @Inject
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val daggerComponent = FoodoraApp.daggerComponent
        daggerComponent.inject(this)

        val query = arguments!!.getString(ARG_QUERY)
        if (query.isNotBlank()) {
            subscriptions.add(
                searchViewModel.search(query)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(::setData, ::handleError)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.text = getString(R.string.msg_empty_search_query)

        resultsList.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        subscriptions.add(
            searchViewModel.searchListener
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .debounce(250, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .flatMapSingle {
                    if (it.isBlank()) {
                        Single.just(queryEmptyList)
                    } else {
                        searchViewModel.search(it)
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen { errors ->
                    errors.flatMap {
                        if (it is InterruptedIOException) Flowable.just("")
                        else Flowable.error(it)
                    }
                }
                .subscribe(::setData, ::handleError)
        )
    }

    private fun setData(recipes: List<Recipe>) {
        showView(emptyView, recipes.isEmpty() || recipes == queryEmptyList)
        showView(resultsList, recipes.isNotEmpty() && recipes != queryEmptyList)

        if (recipes.isEmpty()) {
            message.text = getString(R.string.msg_error_no_results)
        } else if (recipes == queryEmptyList) {
            message.text = getString(R.string.msg_empty_search_query)
        } else {
            if (::adapter.isInitialized.not()) {
                adapter = RecipesAdapter(recipes, true)
                resultsList.recyclerView.adapter = adapter
            } else adapter.submitList(recipes)
        }
    }

    override fun onDestroyView() {
        subscriptions.clear()
        super.onDestroyView()
    }

    private fun handleError(error: Throwable) {
        onError(error, requireContext())
    }

    companion object {
        fun newInstance(query: String): SearchFragment {
            return SearchFragment().apply {
                val args = Bundle().apply { putString(ARG_QUERY, query) }
                arguments = args
            }
        }
    }
}
