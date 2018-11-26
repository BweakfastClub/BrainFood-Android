package club.bweakfast.foodora.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.database.sqlite.transaction
import club.bweakfast.foodora.util.log
import javax.inject.Singleton

@Singleton
class FoodoraDB(context: Context) : SQLiteOpenHelper(context, "foodora-db", null, 2) {
    override fun onCreate(db: SQLiteDatabase) {
        log("Creating DB")
        db.transaction {
            db.execSQL(recipeCreationSQL)
            db.execSQL(ingredientsCreationSQL)
            db.execSQL(nutritionCreationSQL)
            db.execSQL(recipeNutritionCreationSQL)
            db.execSQL(recipeIngredientCreationSQL)
            db.execSQL(likedRecipesCreationSQL)
            db.execSQL(mealPlanCreationSQL)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        log("Upgrading from $oldVersion to $newVersion")
        var dbVersion = oldVersion + 1
        do {
            when (dbVersion) {
                2 -> {
                    db.transaction {
                        db.execSQL(likedRecipesCreationSQL)
                        db.execSQL(mealPlanCreationSQL)
                        db.execSQL("DELETE FROM $TABLE_FAVOURITE_NAME;")
                    }
                }
            }
            dbVersion += 1
        } while (dbVersion <= newVersion)
    }

    fun clearDB() {
        writableDatabase.transaction {
            execSQL("DELETE FROM $TABLE_MEAL_PLAN_NAME")
            execSQL("DELETE FROM $TABLE_LIKED_RECIPES_NAME")
            execSQL("DELETE FROM $TABLE_RECIPE_INGREDIENT_NAME")
            execSQL("DELETE FROM $TABLE_RECIPE_NUTRITION_NAME")
            execSQL("DELETE FROM $TABLE_NUTRITION_NAME")
            execSQL("DELETE FROM $TABLE_INGREDIENT_NAME")
            execSQL("DELETE FROM $TABLE_RECIPE_NAME")
        }
    }
}