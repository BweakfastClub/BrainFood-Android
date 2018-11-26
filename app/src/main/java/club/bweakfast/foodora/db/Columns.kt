package club.bweakfast.foodora.db

const val COLUMN_FAVOURITE_ID = "id"
const val COLUMN_FAVOURITE_TYPE = "type"
const val TABLE_FAVOURITE_NAME = "favourites"

const val COLUMN_RECIPE_ID = "id"
const val COLUMN_RECIPE_TITLE = "title"
const val COLUMN_RECIPE_SERVINGS = "servings"
const val COLUMN_RECIPE_PREP_MINS = "prep_minutes"
const val COLUMN_RECIPE_COOK_MINS = "cook_minutes"
const val COLUMN_RECIPE_READY_MINS = "ready_minutes"
const val COLUMN_RECIPE_IMG_URL = "image_url"
const val TABLE_RECIPE_NAME = "recipes"

const val COLUMN_INGREDIENT_ID = "id"
const val COLUMN_INGREDIENT_NAME = "name"
const val COLUMN_INGREDIENT_GRAMS = "grams"
const val COLUMN_INGREDIENT_DISPLAY_TYPE = "display_type"
const val TABLE_INGREDIENT_NAME = "ingredients"

const val COLUMN_NUTRITION_ID = "id"
const val COLUMN_NUTRITION_NAME = "name"
const val COLUMN_NUTRITION_AMOUNT = "amount"
const val COLUMN_NUTRITION_UNIT = "unit"
const val COLUMN_NUTRITION_DISPLAY_VALUE = "display_value"
const val COLUMN_NUTRITION_DAILY_VALUE = "daily_value"
const val COLUMN_NUTRITION_COMPLETE_DATA = "is_complete_data"
const val TABLE_NUTRITION_NAME = "nutrition"

const val COLUMN_REL_RECIPE_ID = "recipe_id"
const val COLUMN_REL_NUTRITION_ID = "nutrition_id"
const val COLUMN_REL_INGREDIENT_ID = "ingredient_id"

const val TABLE_RECIPE_NUTRITION_NAME = "recipe_nutrition"
const val TABLE_RECIPE_INGREDIENT_NAME = "recipe_ingredient"

const val TABLE_LIKED_RECIPES_NAME = "liked_recipes"

const val COLUMN_CATEGORY_NAME = "category_name"

const val TABLE_MEAL_PLAN_NAME = "meal_plan"