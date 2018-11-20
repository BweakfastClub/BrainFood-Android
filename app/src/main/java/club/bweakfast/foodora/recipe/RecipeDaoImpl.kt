package club.bweakfast.foodora.recipe

import androidx.core.content.contentValuesOf
import club.bweakfast.foodora.db.COLUMN_RECIPE_COOK_MINS
import club.bweakfast.foodora.db.COLUMN_RECIPE_ID
import club.bweakfast.foodora.db.COLUMN_RECIPE_IMG_URL
import club.bweakfast.foodora.db.COLUMN_RECIPE_PREP_MINS
import club.bweakfast.foodora.db.COLUMN_RECIPE_READY_MINS
import club.bweakfast.foodora.db.COLUMN_RECIPE_SERVINGS
import club.bweakfast.foodora.db.COLUMN_RECIPE_TITLE
import club.bweakfast.foodora.db.FoodoraDB
import club.bweakfast.foodora.db.TABLE_RECIPE_NAME
import club.bweakfast.foodora.util.insert
import club.bweakfast.foodora.util.map
import club.bweakfast.foodora.util.query
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RecipeDaoImpl @Inject constructor(private val foodoraDB: FoodoraDB) : RecipeDao {
    override fun getRecipes(recipeIDs: List<Int>?): Single<List<Recipe>> {
        return Single.create {
            val db = foodoraDB.readableDatabase
            val cursor = if (recipeIDs == null) {
                db.query(TABLE_RECIPE_NAME)
            } else {
                db.query(
                    table = TABLE_RECIPE_NAME,
                    selection = "$COLUMN_RECIPE_ID IN (${recipeIDs.joinToString(", ") { "?" }})",
                    selectionArgs = recipeIDs.map { it.toString() }.toTypedArray()
                )
            }

            it.onSuccess(cursor.map { Recipe.createFromCursor(it, emptyList()) })
        }
    }

    override fun addRecipe(recipe: Recipe): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            with(recipe) {
                db.insert(
                    TABLE_RECIPE_NAME,
                    contentValuesOf(
                        COLUMN_RECIPE_ID to id,
                        COLUMN_RECIPE_TITLE to title,
                        COLUMN_RECIPE_SERVINGS to servings,
                        COLUMN_RECIPE_PREP_MINS to prepMinutes,
                        COLUMN_RECIPE_COOK_MINS to cookMinutes,
                        COLUMN_RECIPE_READY_MINS to readyMinutes,
                        COLUMN_RECIPE_IMG_URL to imageURL
                    )
                )
                it.onComplete()
            }
        }
    }

    override fun removeRecipe(recipe: Recipe): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            db.delete(TABLE_RECIPE_NAME, "$COLUMN_RECIPE_ID = ?", arrayOf(recipe.id.toString()))
            it.onComplete()
        }
    }
}