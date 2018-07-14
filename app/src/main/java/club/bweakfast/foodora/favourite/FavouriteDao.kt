package club.bweakfast.foodora.favourite

import io.reactivex.Completable
import io.reactivex.Single

interface FavouriteDao {
    fun getFavourites(): Single<List<Int>>

    fun getFavourites(type: FavouriteType): Single<List<Int>>

    fun addFavourite(favourite: Favourite): Completable

    fun removeFavourite(favourite: Favourite): Completable
}
