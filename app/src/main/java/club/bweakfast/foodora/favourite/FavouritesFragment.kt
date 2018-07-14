package club.bweakfast.foodora.favourite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.recipe.RecipeViewModel
import club.bweakfast.foodora.recipe.RecipesListFragment
import club.bweakfast.foodora.util.log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [FavouritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FavouritesFragment : RecipesListFragment() {
    @Inject
    lateinit var recipeViewModel: RecipeViewModel

    private val subscriptions = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val daggerComponent = FoodoraApp.daggerComponent
        daggerComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()

        subscriptions.add(
            recipeViewModel.getFavouriteRecipes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { recipes, e ->
                    this.recipes = recipes
                    e?.let { log(it.localizedMessage, Log.ERROR) }
                }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = FavouritesFragment()
    }
}
