package club.bweakfast.foodora

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import club.bweakfast.foodora.favourite.FavouriteDaoImpl
import club.bweakfast.foodora.recipe.RecipeDaoImpl
import club.bweakfast.foodora.util.log
import javax.inject.Singleton

@Singleton
class FoodoraDB(context: Context) : SQLiteOpenHelper(context, "foodora-db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val favouritesColID = FavouriteDaoImpl.COLUMN_ID
        val favouritesColType = FavouriteDaoImpl.COLUMN_TYPE
        val favouritesCreationSQL =
            "CREATE TABLE ${FavouriteDaoImpl.TABLE_NAME} ($favouritesColID INTEGER NOT NULL, $favouritesColType INTEGER NOT NULL, PRIMARY KEY ($favouritesColID));"

        val recipesColID = RecipeDaoImpl.COLUMN_ID
        val recipesColTitle = RecipeDaoImpl.COLUMN_TITLE
        val recipesColServings = RecipeDaoImpl.COLUMN_SERVINGS
        val recipesColCookTime = RecipeDaoImpl.COLUMN_COOK_MINS
        val recipesColPrepTime = RecipeDaoImpl.COLUMN_PREP_MINS
        val recipesColReadyTime = RecipeDaoImpl.COLUMN_READY_MINS
        val recipesColImgUrl = RecipeDaoImpl.COLUMN_IMG_URL
        val recipeCreationSQL =
            "CREATE TABLE ${RecipeDaoImpl.TABLE_NAME} ($recipesColID INTEGER NOT NULL, $recipesColTitle TEXT NOT NULL, $recipesColServings INTEGER NOT NULL, $recipesColCookTime INTEGER NOT NULL, $recipesColPrepTime INTEGER NOT NULL, $recipesColReadyTime INTEGER NOT NULL, $recipesColImgUrl TEXT NOT NULL, PRIMARY KEY ($recipesColID));"

        log("Creating DB")
        db.execSQL(favouritesCreationSQL)
        db.execSQL(recipeCreationSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        log("Upgrading from $oldVersion to $newVersion")
    }
}