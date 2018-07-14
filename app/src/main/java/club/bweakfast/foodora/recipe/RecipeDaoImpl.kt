package club.bweakfast.foodora.recipe

import androidx.core.content.contentValuesOf
import club.bweakfast.foodora.FoodoraDB
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
                db.query(TABLE_NAME)
            } else {
                db.query(
                    table = TABLE_NAME,
                    selection = "$COLUMN_ID IN (${recipeIDs.joinToString(", ") { "?" }})",
                    selectionArgs = recipeIDs.map { it.toString() }.toTypedArray()
                )
            }

            it.onSuccess(cursor.map { Recipe.createFromCursor(it) })
        }
    }

    override fun addRecipe(recipe: Recipe): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            with(recipe) {
                db.insert(
                    TABLE_NAME,
                    contentValuesOf(
                        COLUMN_ID to id,
                        COLUMN_TITLE to title,
                        COLUMN_SERVINGS to servings,
                        COLUMN_PREP_MINS to prepMinutes,
                        COLUMN_COOK_MINS to cookMinutes,
                        COLUMN_READY_MINS to readyMinutes,
                        COLUMN_IMG_URL to imageURL
                    )
                )
                it.onComplete()
            }
        }
    }

    override fun removeRecipe(recipe: Recipe): Completable {
        return Completable.create {
            val db = foodoraDB.writableDatabase
            db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(recipe.id.toString()))
            it.onComplete()
        }
    }

    companion object {
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_SERVINGS = "servings"
        const val COLUMN_PREP_MINS = "prep_minutes"
        const val COLUMN_COOK_MINS = "cook_minutes"
        const val COLUMN_READY_MINS = "ready_minutes"
        const val COLUMN_IMG_URL = "image_url"
        const val TABLE_NAME = "recipes"
    }
}