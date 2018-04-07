package club.bweakfast.foodora.search

import club.bweakfast.foodora.network.ServerResponse
import club.bweakfast.foodora.recipe.Recipe
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by silve on 3/5/2018.
 */

class SearchService @Inject constructor(retrofit: Retrofit) {
    private val api = retrofit.create(SearchAPI::class.java)

    fun search(query: String) = api.search(query)

    interface SearchAPI {
        fun search(@Query("q") query: String): Single<Response<ServerResponse<List<Recipe>>>>
    }
}