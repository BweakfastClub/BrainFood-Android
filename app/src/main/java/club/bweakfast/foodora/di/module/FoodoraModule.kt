package club.bweakfast.foodora.di.module

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.preference.PreferenceManager
import club.bweakfast.foodora.BuildConfig
import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.db.FoodoraDB
import club.bweakfast.foodora.recipe.RecipeDao
import club.bweakfast.foodora.recipe.RecipeDaoImpl
import club.bweakfast.foodora.recipe.ingredient.IngredientDao
import club.bweakfast.foodora.recipe.ingredient.IngredientDaoImpl
import club.bweakfast.foodora.recipe.nutrition.NutritionDao
import club.bweakfast.foodora.recipe.nutrition.NutritionDaoImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by silve on 3/2/2018.
 */

@Module
class FoodoraModule(private val context: Context) {
    @Provides
    fun provideRetrofit(storageService: StorageService): Retrofit {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor {
            val originalRequest = it.request()
            if (storageService.hasToken()) {
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val requestBuilder = originalRequest
                    .newBuilder()
                    .addHeader("token", storageService.token)
                val request = requestBuilder.build()
                it.proceed(request)
            } else {
                it.proceed(originalRequest)
            }
        }
        val client = clientBuilder.build()
        retrofit.client(client)
        return retrofit.build()
    }

    @Provides
    fun provideContext() = context

    @Provides
    fun provideDB(context: Context) = FoodoraDB(context)

    @Provides
    fun provideIngredientDao(db: FoodoraDB): IngredientDao = IngredientDaoImpl(db)

    @Provides
    fun provideNutritionDao(db: FoodoraDB): NutritionDao = NutritionDaoImpl(db)

    @Provides
    fun provideRecipeDao(db: FoodoraDB, ingredientDao: IngredientDao, nutritionDao: NutritionDao): RecipeDao {
        return RecipeDaoImpl(db, ingredientDao, nutritionDao)
    }

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
}