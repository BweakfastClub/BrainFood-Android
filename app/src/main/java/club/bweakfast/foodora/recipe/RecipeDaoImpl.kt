package club.bweakfast.foodora.recipe

import android.database.sqlite.SQLiteConstraintException
import androidx.core.content.contentValuesOf
import androidx.core.database.getInt
import androidx.core.database.getString
import androidx.core.database.sqlite.transaction
import club.bweakfast.foodora.db.COLUMN_CATEGORY_NAME
import club.bweakfast.foodora.db.COLUMN_RECIPE_COOK_MINS
import club.bweakfast.foodora.db.COLUMN_RECIPE_ID
import club.bweakfast.foodora.db.COLUMN_RECIPE_IMG_URL
import club.bweakfast.foodora.db.COLUMN_RECIPE_PREP_MINS
import club.bweakfast.foodora.db.COLUMN_RECIPE_READY_MINS
import club.bweakfast.foodora.db.COLUMN_RECIPE_SERVINGS
import club.bweakfast.foodora.db.COLUMN_RECIPE_TITLE
import club.bweakfast.foodora.db.COLUMN_REL_RECIPE_ID
import club.bweakfast.foodora.db.FoodoraDB
import club.bweakfast.foodora.db.TABLE_LIKED_RECIPES_NAME
import club.bweakfast.foodora.db.TABLE_MEAL_PLAN_NAME
import club.bweakfast.foodora.db.TABLE_RECIPE_NAME
import club.bweakfast.foodora.db.createRecipeFromCursor
import club.bweakfast.foodora.recipe.ingredient.IngredientDao
import club.bweakfast.foodora.recipe.nutrition.NutritionDao
import club.bweakfast.foodora.util.insertOrThrow
import club.bweakfast.foodora.util.map
import club.bweakfast.foodora.util.query
import club.bweakfast.foodora.util.useFirst
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RecipeDaoImpl @Inject constructor(
    private val foodoraDB: FoodoraDB,
    private val ingredientDao: IngredientDao,
    private val nutritionDao: NutritionDao
) : RecipeDao {
    override fun getRecipes(recipeIDs: List<Int>?): Single<List<Recipe>> = Single.create { it.onSuccess(getRecipesList(recipeIDs)) }

    override fun getRecipesList(recipeIDs: List<Int>?): List<Recipe> {
        val db = foodoraDB.readableDatabase
        val recipeCursor = if (recipeIDs == null) {
            db.query(TABLE_RECIPE_NAME)
        } else {
            db.query(
                table = TABLE_RECIPE_NAME,
                selection = "$COLUMN_RECIPE_ID IN (${recipeIDs.joinToString(", ") { "?" }})",
                selectionArgs = recipeIDs.map { it.toString() }.toTypedArray()
            )
        }

        return recipeCursor.use {
            it.map {
                val recipeID = recipeCursor.getInt(COLUMN_RECIPE_ID)
                val ingredients = ingredientDao.getIngredientsList(recipeID)
                val nutrition = nutritionDao.getNutritionList(recipeID)

                createRecipeFromCursor(this, ingredients, nutrition)
            }
        }
    }

    override fun getRecipe(recipeID: Int): Single<Recipe> = Single.create { it.onSuccess(getRecipeVal(recipeID)) }

    override fun getRecipeVal(recipeID: Int): Recipe {
        val db = foodoraDB.readableDatabase
        val recipeCursor = db.query(TABLE_RECIPE_NAME, selection = "$COLUMN_RECIPE_ID = ?", selectionArgs = arrayOf(recipeID.toString()))

        val ingredients = ingredientDao.getIngredientsList(recipeID)
        val nutrition = nutritionDao.getNutritionList(recipeID)

        return recipeCursor.useFirst { createRecipeFromCursor(recipeCursor, ingredients, nutrition) }
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