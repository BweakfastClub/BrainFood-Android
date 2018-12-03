package club.bweakfast.foodora.recipe

import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

class RecipeService @Inject constructor(retrofit: Retrofit) {
    private val api = retrofit.create(RecipeAPI::class.java)

    fun likeRecipe(recipeID: Int) = api.likeRecipe(mapOf("recipeIds" to listOf(recipeID))).mapResponse()

    fun unlikeRecipe(recipeID: Int) = api.unlikeRecipe(mapOf("recipeIds" to listOf(recipeID))).mapResponse()

    fun addRecipeToMealPlan(recipeID: Int, categoryNames: List<String>): Completable {
        return api.addRecipeToMealPlan(categoryNames.associate { it to listOf(recipeID) }).mapResponse()
    }

    fun removeRecipeFromMealPlan(recipeID: Int, categoryName: String): Completable {
        return api.removeRecipeFromMealPlan(mapOf(categoryName to listOf(recipeID))).mapResponse()
    }

    fun getTopRecipes() = api.getTopRecipes().mapResponse()

    fun getRecommendedRecipes(recipeID: Int? = null): Single<List<Recipe>> {
        return (recipeID?.let { api.getSimilarRecipes(it) } ?: api.getRecommendedRecipes()).mapResponse()
    }

    fun getRandomRecipes(numRecipes: Int = 8) = api.getRandomRecipes(numRecipes).mapResponse()

    interface RecipeAPI {
        @POST("/users/liked_recipes")
        fun likeRecipe(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @HTTP(method = "DELETE", path = "/users/liked_recipes", hasBody = true)
        fun unlikeRecipe(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @POST("/users/meal_plan")
        fun addRecipeToMealPlan(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @HTTP(method = "DELETE", path = "/users/meal_plan", hasBody = true)
        fun removeRecipeFromMealPlan(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @GET("/recipes/top_recipes")
        fun getTopRecipes(): Single<Response<List<Recipe>>>

        @GET("/users/recommended_recipes")
        fun getRecommendedRecipes(): Single<Response<List<Recipe>>>

        @GET("/recipes/random")
        fun getRandomRecipes(@Query("recipes") numRecipes: Int): Single<Response<List<Recipe>>>

        @GET("/recipes/recommend/{recipeID}")
        fun getSimilarRecipes(@Path("recipeID") recipeID: Int): Single<Response<List<Recipe>>>
    }
}