package club.bweakfast.foodora.di.module

import android.content.Context
import android.content.SharedPreferences
import club.bweakfast.foodora.db.FoodoraDB
import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.di.RetrofitContainer
import club.bweakfast.foodora.favourite.FavouriteDao
import club.bweakfast.foodora.favourite.FavouriteDaoImpl
import club.bweakfast.foodora.recipe.RecipeDao
import club.bweakfast.foodora.recipe.RecipeDaoImpl
import club.bweakfast.foodora.recipe.ingredient.IngredientDao
import club.bweakfast.foodora.recipe.ingredient.IngredientDaoImpl
import club.bweakfast.foodora.setup.SetupViewModel
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dagger.Module
import dagger.Provides
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyString
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class FoodoraTestModule(private val context: Context) {
    @Provides
    fun provideRetrofit() = mock<Retrofit>()

    @Provides
    fun provideContext() = context

    @Provides
    fun provideFoodoraDB(context: Context) = FoodoraDB(context)

    @Provides
    fun provideFavouriteDao(db: FoodoraDB): FavouriteDao = FavouriteDaoImpl(db)

    @Provides
    fun provideIngredientDao(db: FoodoraDB): IngredientDao = IngredientDaoImpl(db)

    @Provides
    fun provideRecipeDao(db: FoodoraDB): RecipeDao = RecipeDaoImpl(db)

    @Provides
    @Singleton
    fun providePreferences(): SharedPreferences {
        return mock {
            whenever(mock.edit()).doReturn(mock())
            val editor = mock.edit()
            whenever(editor.putBoolean(anyString(), anyBoolean())).doReturn(editor)
        }
    }

    @Provides
    @Singleton
    fun providesAuthService(): AuthenticationService {
        val mock = mock<AuthenticationService>()
        whenever(mock.api).doReturn(mock())
        return mock
    }

    @Provides
    @Singleton
    fun provideStorageService(sharedPreferences: SharedPreferences): StorageService {
        val mock = mock<StorageService>()
        whenever(mock.preferences).doReturn(sharedPreferences)
        StorageService.nameKey = ""
        StorageService.veganKey = ""
        StorageService.vegetarianKey = ""
        StorageService.peanutAllergyKey = ""
        StorageService.currentPasswordKey = ""
        StorageService.newPasswordKey = ""
        return mock
    }

    @Provides
    @Singleton
    fun provideSetupViewModel(storageService: StorageService): SetupViewModel {
        val mock = mock<SetupViewModel>()
        whenever(mock.storageService).doReturn(storageService)
        return mock
    }
}