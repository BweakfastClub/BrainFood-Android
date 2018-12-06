package club.bweakfast.foodora.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R
import club.bweakfast.foodora.recipe.RecipeViewModel
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.user.UserViewModel
import club.bweakfast.foodora.util.onError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {
    @Inject
    lateinit var userViewModel: UserViewModel
    @Inject
    lateinit var recipeViewModel: RecipeViewModel

    private val subscriptions = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FoodoraApp.daggerComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeRefreshLayout.setOnRefreshListener { loadData() }
        loadData()
    }

    private fun loadData() {
        subscriptions.add(
            recipeViewModel.getTopRecipes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { recipes, err ->
                    if (err != null) {
                        onError(err, requireContext()) { _, _ -> getString(R.string.error_fail_top_recipes) }
                    } else {
                        topRecipesGrid.recyclerView.isNestedScrollingEnabled = false
                        topRecipesGrid.recyclerView.adapter = RecipesAdapter(recipes, true)
                        topRecipesGrid.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                    }
                }
        )

        if (userViewModel.isLoggedIn) {
            subscriptions.add(
                recipeViewModel.getRecommendedRecipes()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe { recipes, err ->
                        if (err != null) {
                            onError(err, requireContext()) { _, _ -> getString(R.string.error_fail_recommended_recipes) }
                        } else {
                            topRecommendations.visibility = View.VISIBLE
                            topRecommendations.recyclerView.isNestedScrollingEnabled = false
                            topRecommendations.recyclerView.adapter = RecipesAdapter(recipes)
                            topRecommendations.recyclerView.layoutManager =
                                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                        }
                        swipeRefreshLayout.isRefreshing = false
                    }
            )
        } else {
            topRecommendations.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        subscriptions.clear()
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
