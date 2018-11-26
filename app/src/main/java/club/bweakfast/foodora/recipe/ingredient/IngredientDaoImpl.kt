package club.bweakfast.foodora.recipe.ingredient

import android.util.Log
import androidx.core.content.contentValuesOf
import androidx.core.database.sqlite.transaction
import club.bweakfast.foodora.db.COLUMN_INGREDIENT_DISPLAY_TYPE
import club.bweakfast.foodora.db.COLUMN_INGREDIENT_GRAMS
import club.bweakfast.foodora.db.COLUMN_INGREDIENT_ID
import club.bweakfast.foodora.db.COLUMN_INGREDIENT_NAME
import club.bweakfast.foodora.db.COLUMN_REL_INGREDIENT_ID
import club.bweakfast.foodora.db.COLUMN_REL_RECIPE_ID
import club.bweakfast.foodora.db.FoodoraDB
import club.bweakfast.foodora.db.TABLE_INGREDIENT_NAME
import club.bweakfast.foodora.db.TABLE_RECIPE_INGREDIENT_NAME
import club.bweakfast.foodora.db.createIngredientFromCursor
import club.bweakfast.foodora.util.insertOrThrow
import club.bweakfast.foodora.util.map
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class IngredientDaoImpl @Inject constructor(private val foodoraDB: FoodoraDB) : IngredientDao {
    override fun getIngredients(recipeID: Int): Single<List<Ingredient>> = Single.create { it.onSuccess(getIngredientsList(recipeID)) }

    override fun getIngredientsList(recipeID: Int): List<Ingredient> {
        val db = foodoraDB.readableDatabase
        val cursor = db.rawQuery(
            """SELECT i.*
                    |FROM $TABLE_INGREDIENT_NAME i
                    |JOIN $TABLE_RECIPE_INGREDIENT_NAME ri ON i.$COLUMN_INGREDIENT_ID = ri.$COLUMN_REL_INGREDIENT_ID
                    |WHERE ri.$COLUMN_REL_RECIPE_ID = ?;""".trimMargin(),
            arrayOf(recipeID.toString())
        )

        return cursor.use { it.map { createIngredientFromCursor(this) } }
    }

    override fun saveIngredients(ingredients: List<Ingredient>, recipeID: Int): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            db.transaction {
                ingredients.forEach {
                    db.insert(
                        TABLE_INGREDIENT_NAME,
                        contentValuesOf(
                            COLUMN_INGREDIENT_ID to it.id,
                            COLUMN_INGREDIENT_NAME to it.name,
                            COLUMN_INGREDIENT_GRAMS to it.grams,
                            COLUMN_INGREDIENT_DISPLAY_TYPE to it.displayType
                        )
                    )
                    db.insert(
                        TABLE_RECIPE_INGREDIENT_NAME,
                        contentValuesOf(
                            COLUMN_REL_RECIPE_ID to recipeID,
                            COLUMN_REL_INGREDIENT_ID to it.id
                        )
                    )
                    log("Adding ingredient ${it.id} to recipe $recipeID", Log.ERROR)
                }
            }
            it.onComplete()
        }
    }

    override fun deleteIngredients(recipeID: Int): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase

        }
    }
}