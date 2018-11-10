package club.bweakfast.foodora.recipe

import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.POST
import javax.inject.Inject

class RecipeService @Inject constructor() {
    val random: Int
        get() = (0..100).random()

    fun likeRecipe(recipeID: Int): Completable {
        return if (random > 95) {
            Single.just(Response.error(500, ResponseBody.create(MediaType.parse("application/json"), null as? String)))
        } else {
            Single.just(Response.success<Void>(null))
        }
            .mapResponse()
    }

    fun unlikeRecipe(recipeID: Int): Completable {
        return if (random > 95) {
            Single.just(Response.error(500, ResponseBody.create(MediaType.parse("application/json"), null as? String)))
        } else {
            Single.just(Response.success<Void>(null))
        }
            .mapResponse()
    }

    fun addRecipeToMealPlan(recipeID: Int): Completable {
        return if (random > 95) {
            Single.just(Response.error(500, ResponseBody.create(MediaType.parse("application/json"), null as? String)))
        } else {
            Single.just(Response.success<Void>(null))
        }
            .mapResponse()
    }

    fun removeRecipeFromMealPlan(recipeID: Int): Completable {
        return if (random > 95) {
            Single.just(Response.error(500, ResponseBody.create(MediaType.parse("application/json"), null as? String)))
        } else {
            Single.just(Response.success<Void>(null))
        }
            .mapResponse()
    }

    fun addAllergies(allergies: List<String>): Completable {
        return if (random > 95) {
            Single.just(Response.error(500, ResponseBody.create(MediaType.parse("application/json"), null as? String)))
        } else {
            Single.just(Response.success<Void>(null))
        }
            .mapResponse()
    }
}