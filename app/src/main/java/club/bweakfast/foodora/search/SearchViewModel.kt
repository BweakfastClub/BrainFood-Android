package club.bweakfast.foodora.search

import club.bweakfast.foodora.recipe.Recipe
import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by silve on 3/5/2018.
 */

@Singleton
class SearchViewModel @Inject constructor(private val searchService: SearchService) {
    lateinit var searchListener: Flowable<String>
    lateinit var searchDisposable: Disposable

    fun isSearchListenerInitialized() = ::searchDisposable.isInitialized

    fun search(query: String): Single<List<Recipe>> = searchService.search(query).mapResponse()
}