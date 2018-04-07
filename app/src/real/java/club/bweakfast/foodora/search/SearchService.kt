package club.bweakfast.foodora.search

import club.bweakfast.foodora.recipe.Recipe
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by silve on 3/5/2018.
 */

class SearchService @Inject constructor(retrofit: Retrofit) {
    private val api = retrofit.create(SearchAPI::class.java)

    fun search(query: String) = api.search(query)

    interface SearchAPI {
        @GET("/recipes/search")
        fun search(@Query("keyword") query: String): Single<Response<List<Recipe>>>
    }
}