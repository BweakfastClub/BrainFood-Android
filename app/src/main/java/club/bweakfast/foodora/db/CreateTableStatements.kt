package club.bweakfast.foodora.db

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

val likedRecipesCreationSQL =
    """CREATE TABLE $TABLE_LIKED_RECIPES_NAME (
                                |$COLUMN_REL_RECIPE_ID INTEGER PRIMARY KEY,
                                |FOREIGN KEY ($COLUMN_REL_RECIPE_ID) REFERENCES $TABLE_RECIPE_NAME ($COLUMN_RECIPE_ID)
                                |);""".trimMargin()

val mealPlanCreationSQL =
    """CREATE TABLE $TABLE_MEAL_PLAN_NAME (
                                |$COLUMN_REL_RECIPE_ID INTEGER NOT NULL,
                                |$COLUMN_CATEGORY_NAME TEXT NOT NULL,
                                |PRIMARY KEY ($COLUMN_REL_RECIPE_ID, $COLUMN_CATEGORY_NAME),
                                |FOREIGN KEY ($COLUMN_REL_RECIPE_ID) REFERENCES $TABLE_RECIPE_NAME ($COLUMN_RECIPE_ID)
                                |);""".trimMargin()