package club.bweakfast.foodora.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import club.bweakfast.foodora.util.log
import javax.inject.Singleton

@Singleton
class FoodoraDB(context: Context) : SQLiteOpenHelper(context, "foodora-db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val favouritesCreationSQL =
            """CREATE TABLE $TABLE_FAVOURITE_NAME (
                |$COLUMN_FAVOURITE_ID INTEGER NOT NULL,
                |$COLUMN_FAVOURITE_TYPE INTEGER NOT NULL,
                |PRIMARY KEY ($COLUMN_FAVOURITE_ID)
                |);""".trimMargin()

        val recipeCreationSQL =
            """CREATE TABLE $TABLE_RECIPE_NAME (
                |$COLUMN_RECIPE_ID INTEGER NOT NULL,
                |$COLUMN_RECIPE_TITLE TEXT NOT NULL,
                |$COLUMN_RECIPE_SERVINGS INTEGER NOT NULL,
                |$COLUMN_RECIPE_COOK_MINS INTEGER NOT NULL,
                |$COLUMN_RECIPE_PREP_MINS INTEGER NOT NULL,
                |$COLUMN_RECIPE_READY_MINS INTEGER NOT NULL,
                |$COLUMN_RECIPE_IMG_URL TEXT NOT NULL,
                |PRIMARY KEY ($COLUMN_RECIPE_ID)
                |);""".trimMargin()

        val ingredientsCreationSQL =
            """CREATE TABLE $TABLE_INGREDIENT_NAME (
                |$COLUMN_INGREDIENT_ID INTEGER NOT NULL,
                |$COLUMN_INGREDIENT_NAME TEXT NOT NULL,
                |$COLUMN_INGREDIENT_GRAMS REAL NOT NULL,
                |$COLUMN_INGREDIENT_DISPLAY_TYPE TEXT NOT NULL,
                |PRIMARY KEY ($COLUMN_INGREDIENT_ID)
                |);""".trimMargin()

        val nutritionCreationSQL =
            """CREATE TABLE $TABLE_NUTRITION_NAME (
                |$COLUMN_NUTRITION_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                |$COLUMN_NUTRITION_NAME TEXT NOT NULL,
                |$COLUMN_NUTRITION_AMOUNT REAL NOT NULL,
                |$COLUMN_NUTRITION_UNIT TEXT,
                |$COLUMN_NUTRITION_DISPLAY_VALUE TEXT,
                |$COLUMN_NUTRITION_DAILY_VALUE TEXT,
                |$COLUMN_NUTRITION_COMPLETE_DATA INTEGER NOT NULL
                |);""".trimMargin()

        val recipeNutritionCreationSQL =
            """CREATE TABLE $TABLE_RECIPE_NUTRITION_NAME (
                |$COLUMN_REL_RECIPE_ID INTEGER NOT NULL,
                |$COLUMN_REL_NUTRITION_ID INTEGER NOT NULL,
                |PRIMARY KEY ($COLUMN_REL_RECIPE_ID, $COLUMN_REL_NUTRITION_ID)
                |FOREIGN KEY ($COLUMN_REL_RECIPE_ID) REFERENCES $TABLE_RECIPE_NAME ($COLUMN_RECIPE_ID)
                |FOREIGN KEY ($COLUMN_REL_NUTRITION_ID) REFERENCES $TABLE_NUTRITION_NAME ($COLUMN_NUTRITION_ID)
                |);""".trimMargin()

        val recipeIngredientCreationSQL =
            """CREATE TABLE $TABLE_RECIPE_INGREDIENT_NAME (
                |$COLUMN_REL_RECIPE_ID INTEGER NOT NULL,
                |$COLUMN_REL_INGREDIENT_ID INTEGER NOT NULL,
                |PRIMARY KEY ($COLUMN_REL_RECIPE_ID, $COLUMN_REL_INGREDIENT_ID)
                |FOREIGN KEY ($COLUMN_REL_RECIPE_ID) REFERENCES $TABLE_RECIPE_NAME ($COLUMN_RECIPE_ID)
                |FOREIGN KEY ($COLUMN_REL_INGREDIENT_ID) REFERENCES $TABLE_INGREDIENT_NAME ($COLUMN_INGREDIENT_ID)
                |);""".trimMargin()

        log("Creating DB")
        db.execSQL(favouritesCreationSQL)
        db.execSQL(recipeCreationSQL)
        db.execSQL(ingredientsCreationSQL)
        db.execSQL(nutritionCreationSQL)
        db.execSQL(recipeNutritionCreationSQL)
        db.execSQL(recipeIngredientCreationSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        log("Upgrading from $oldVersion to $newVersion")
    }
}