package club.bweakfast.foodora.di.component

import club.bweakfast.foodora.auth.AuthenticationActivity
import club.bweakfast.foodora.di.module.FoodoraModule
import club.bweakfast.foodora.favourite.FavouritesFragment
import club.bweakfast.foodora.recipe.RecipeActivity
import club.bweakfast.foodora.search.SearchFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by silve on 3/2/2018.
 */

@Singleton
@Component(modules = [FoodoraModule::class])
interface FoodoraComponent {
    fun inject(activity: AuthenticationActivity)
    fun inject(fragment: SearchFragment)
    fun inject(recipeActivity: RecipeActivity)
    fun inject(favouritesFragment: FavouritesFragment)
}