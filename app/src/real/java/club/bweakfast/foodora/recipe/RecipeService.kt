package club.bweakfast.foodora.recipe

import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.POST
import javax.inject.Inject

class RecipeService @Inject constructor(retrofit: Retrofit) {
    private val api = retrofit.create(RecipeAPI::class.java)

    fun likeRecipe(recipeID: Int) = api.likeRecipe(mapOf("recipeIds" to listOf(recipeID))).mapResponse()

    fun unlikeRecipe(recipeID: Int) = api.unlikeRecipe(mapOf("recipeIds" to listOf(recipeID))).mapResponse()

    fun addRecipeToMealPlan(recipeID: Int) = api.addRecipeToMealPlan(mapOf("recipeIds" to listOf(recipeID))).mapResponse()

    fun removeRecipeFromMealPlan(recipeID: Int) = api.removeRecipeFromMealPlan(mapOf("recipeIds" to listOf(recipeID))).mapResponse()

    fun addAllergies(allergies: List<String>) = api.addAllergies(mapOf("allergies" to allergies)).mapResponse()

    interface RecipeAPI {
        @POST("/users/liked_recipes")
        fun likeRecipe(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @HTTP(method = "DELETE", path = "/users/liked_recipes", hasBody = true)
        fun unlikeRecipe(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @POST("/users/meal_plan")
        fun addRecipeToMealPlan(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @HTTP(method = "DELETE", path = "/users/meal_plan", hasBody = true)
        fun removeRecipeFromMealPlan(@Body recipeIDJSON: Map<String, @JvmSuppressWildcards List<Int>>): Single<Response<Void>>

        @POST("/users/allergies")
        fun addAllergies(@Body allergiesJSON: Map<String, @JvmSuppressWildcards List<String>>): Single<Response<Void>>
    }
}