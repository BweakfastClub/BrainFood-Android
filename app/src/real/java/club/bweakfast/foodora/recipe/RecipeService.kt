package club.bweakfast.foodora.recipe

import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

class RecipeService @Inject constructor(retrofit: Retrofit) {
    private val api = retrofit.create(RecipeAPI::class.java)

    fun likeRecipe(recipeID: Int) = api.likeRecipe(mapOf("recipeId" to recipeID.toString()))

    fun unlikeRecipe(recipeID: Int) = api.unlikeRecipe(mapOf("recipeId" to recipeID.toString()))

    interface RecipeAPI {
        @POST("/users/likes_recipe")
        fun likeRecipe(@Body recipeIDJSON: Map<String, String>): Single<Response<Void>>

        @POST("/users/unlikes_recipe")
        fun unlikeRecipe(@Body recipeIDJSON: Map<String, String>): Single<Response<Void>>
    }
}