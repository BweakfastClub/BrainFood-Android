package club.bweakfast.foodora.search

import club.bweakfast.foodora.recipe.Recipe
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

/**
 * Created by silve on 3/5/2018.
 */

class SearchService @Inject constructor(retrofit: Retrofit) {
    private val api = retrofit.create(SearchAPI::class.java)

    fun search(query: String) = api.search(mapOf("query" to mapOf("\$text" to mapOf("\$search" to query))))

    interface SearchAPI {
        @POST("/recipes/search")
        fun search(@Body query: Map<String, @JvmSuppressWildcards Map<String, @JvmSuppressWildcards Map<String, String>>>): Single<Response<List<Recipe>>>
    }
}