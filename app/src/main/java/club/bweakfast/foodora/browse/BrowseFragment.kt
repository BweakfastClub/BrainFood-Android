package club.bweakfast.foodora.browse


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.R
import club.bweakfast.foodora.browse.category.CategoryAdapter
import club.bweakfast.foodora.browse.category.CategoryName
import club.bweakfast.foodora.onError
import club.bweakfast.foodora.showFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_browse.*
import kotlinx.android.synthetic.main.layout_toolbar.*


/**
 * A simple [Fragment] subclass.
 */
class BrowseFragment : Fragment() {
    private val subscriptions = CompositeDisposable()
    private val clickCategory: PublishSubject<CategoryName> = PublishSubject.create()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryGrid.layoutManager = LinearLayoutManager(context!!)
        categoryGrid.adapter = CategoryAdapter(clickCategory)

        subscriptions.add(
            clickCategory
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.trampoline())
                .subscribe({
                    val fragment = BrowseCategoryFragment.newInstance(it)
                    requireActivity().showFragment(
                        fragment,
                        "Browse${it}Fragment"
                    )
                }, ::handleError)
        )
    }

    override fun onStop() {
        super.onStop()
        subscriptions.clear()
    }

    private fun handleError(throwable: Throwable) {
        onError(throwable, requireContext())
    }

    companion object {
        fun newInstance() = BrowseFragment()
    }
}
