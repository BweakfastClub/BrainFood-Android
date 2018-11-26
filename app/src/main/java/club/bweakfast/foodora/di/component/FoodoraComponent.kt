package club.bweakfast.foodora.di.component

import club.bweakfast.foodora.SplashScreenActivity
import club.bweakfast.foodora.auth.AuthenticationActivity
import club.bweakfast.foodora.auth.RegisterFragment
import club.bweakfast.foodora.custom.CustomToolbarActivity
import club.bweakfast.foodora.di.module.FoodoraModule
import club.bweakfast.foodora.home.HomeFragment
import club.bweakfast.foodora.plan.MealPlanFragment
import club.bweakfast.foodora.recipe.RecipeActivity
import club.bweakfast.foodora.search.SearchFragment
import club.bweakfast.foodora.settings.SettingsActivity
import club.bweakfast.foodora.settings.SettingsFragment
import club.bweakfast.foodora.setup.SetupInfoActivity
import club.bweakfast.foodora.setup.SetupMealsFragment
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
    fun inject(activity: RecipeActivity)
    fun inject(fragment: HomeFragment)
    fun inject(activity: CustomToolbarActivity)
    fun inject(activity: SetupInfoActivity)
    fun inject(fragment: SetupMealsFragment)
    fun inject(fragment: RegisterFragment)
    fun inject(activity: SplashScreenActivity)
    fun inject(activity: SettingsActivity)
    fun inject(fragment: SettingsFragment)
    fun inject(fragment: MealPlanFragment)
}