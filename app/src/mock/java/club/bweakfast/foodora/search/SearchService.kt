package club.bweakfast.foodora.search

import club.bweakfast.foodora.breakfastRecipes
import club.bweakfast.foodora.dinnerRecipes
import club.bweakfast.foodora.lunchRecipes
import club.bweakfast.foodora.network.ServerResponse
import club.bweakfast.foodora.recipe.Recipe
import club.bweakfast.foodora.snacks
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by silve on 3/5/2018.
 */

@Singleton
class SearchService @Inject constructor() {
    private val recipes = listOf(breakfastRecipes, lunchRecipes, dinnerRecipes, snacks).flatten()

    fun search(query: String): Single<Response<List<Recipe>>> {
        return Single.just(
            Response.success(
                recipes.filter {
                    it.title.contains(query)
                }
            )
        )
    }
}