package club.bweakfast.foodora.db

import android.database.Cursor
import androidx.core.database.getFloat
import androidx.core.database.getInt
import androidx.core.database.getString
import androidx.core.database.getStringOrNull
import club.bweakfast.foodora.recipe.Recipe
import club.bweakfast.foodora.recipe.ingredient.Ingredient
import club.bweakfast.foodora.recipe.nutrition.NutritionValue
import club.bweakfast.foodora.util.getBoolean

fun createIngredientFromCursor(cursor: Cursor): Ingredient {
    with(cursor) {
        return Ingredient(
            getInt(COLUMN_INGREDIENT_ID),
            getString(COLUMN_INGREDIENT_NAME),
            getFloat(COLUMN_INGREDIENT_GRAMS),
            getString(COLUMN_INGREDIENT_DISPLAY_TYPE)
        )
    }
}

fun createRecipeFromCursor(cursor: Cursor, ingredients: List<Ingredient>, nutrition: List<NutritionValue>): Recipe {
    with(cursor) {
        return Recipe(
            getInt(COLUMN_RECIPE_ID),
            ingredients,
            getString(COLUMN_RECIPE_TITLE),
            getInt(COLUMN_RECIPE_SERVINGS),
            getInt(COLUMN_RECIPE_PREP_MINS),
            getInt(COLUMN_RECIPE_COOK_MINS),
            getInt(COLUMN_RECIPE_READY_MINS),
            getString(COLUMN_RECIPE_IMG_URL)
        ).apply {
            this.nutrition = nutrition.associate { it.name.toLowerCase() to it }.toMutableMap()
        }
    }
}

fun createNutritionValueFromCursor(cursor: Cursor): NutritionValue {
    with(cursor) {
        return NutritionValue(
            getString(COLUMN_NUTRITION_NAME),
            getFloat(COLUMN_NUTRITION_AMOUNT),
            getStringOrNull(COLUMN_NUTRITION_UNIT),
            getStringOrNull(COLUMN_NUTRITION_DISPLAY_VALUE),
            getStringOrNull(COLUMN_NUTRITION_DAILY_VALUE),
            getBoolean(COLUMN_NUTRITION_COMPLETE_DATA)
        )
    }
}