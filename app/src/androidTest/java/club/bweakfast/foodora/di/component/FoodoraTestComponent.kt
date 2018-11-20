package club.bweakfast.foodora.di.component

import android.content.SharedPreferences
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.di.module.FoodoraTestModule
import club.bweakfast.foodora.recipe.ingredient.IngredientDaoTest
import club.bweakfast.foodora.setup.SetupViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FoodoraTestModule::class])
interface FoodoraTestComponent : FoodoraComponent {
    fun sharedPreferences(): SharedPreferences
    fun authService(): AuthenticationService
    fun setupViewModel(): SetupViewModel

    fun inject(unitTest: IngredientDaoTest)
}