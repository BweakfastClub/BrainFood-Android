package club.bweakfast.foodora.favourite

import androidx.core.content.contentValuesOf
import androidx.core.database.getInt
import club.bweakfast.foodora.db.COLUMN_FAVOURITE_ID
import club.bweakfast.foodora.db.COLUMN_FAVOURITE_TYPE
import club.bweakfast.foodora.db.FoodoraDB
import club.bweakfast.foodora.db.TABLE_FAVOURITE_NAME
import club.bweakfast.foodora.util.insert
import club.bweakfast.foodora.util.map
import club.bweakfast.foodora.util.query
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class FavouriteDaoImpl @Inject constructor(private val foodoraDB: FoodoraDB) : FavouriteDao {
    override fun getFavourites(): Single<List<Int>> {
        return Single.create {
            val db = foodoraDB.readableDatabase
            val cursor = db.query(TABLE_FAVOURITE_NAME, arrayOf(COLUMN_FAVOURITE_ID))

            it.onSuccess(cursor.map { it.getInt(COLUMN_FAVOURITE_ID) })
        }
    }

    override fun getFavourites(type: FavouriteType): Single<List<Int>> {
        return Single.create {
            val db = foodoraDB.readableDatabase
            val cursor = db.query(TABLE_FAVOURITE_NAME, arrayOf(COLUMN_FAVOURITE_ID), "$COLUMN_FAVOURITE_TYPE = ?", arrayOf(type.ordinal.toString()))

            it.onSuccess(cursor.map { it.getInt(COLUMN_FAVOURITE_ID) })
        }
    }

    override fun addFavourite(favourite: Favourite): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            db.insert(TABLE_FAVOURITE_NAME, contentValuesOf(COLUMN_FAVOURITE_ID to favourite.id, COLUMN_FAVOURITE_TYPE to favourite.type.ordinal))
            it.onComplete()
        }
    }

    override fun removeFavourite(favourite: Favourite): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            db.delete(TABLE_FAVOURITE_NAME, "$COLUMN_FAVOURITE_ID = ?", arrayOf(favourite.id.toString()))
            it.onComplete()
        }
    }
}