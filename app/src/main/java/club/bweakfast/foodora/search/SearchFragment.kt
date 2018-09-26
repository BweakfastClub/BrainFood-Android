package club.bweakfast.foodora.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.util.onError
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.view_recipe_list.view.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    private val subscriptions: CompositeDisposable = CompositeDisposable()
    private var adapter: RecipesAdapter? = null

    @Suppress("MemberVisibilityCanBePrivate")
    @Inject
    lateinit var searchViewModel: SearchViewModel
    lateinit var searchListener: Flowable<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val daggerComponent = FoodoraApp.daggerComponent
        daggerComponent.inject(this)
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

        resultsList.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        subscriptions.add(
            searchListener
                .subscribeOn(Schedulers.io())
                .debounce(250, TimeUnit.MILLISECONDS)
                .flatMapSingle { searchViewModel.search(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (adapter == null)
                        adapter = RecipesAdapter(it, true)
                    else
                        adapter!!.submitList(it)

                    resultsList.recyclerView.adapter = adapter
                }, ::handleError)
        )
    }

    private fun handleError(throwable: Throwable) {
        onError(throwable, requireContext())
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
