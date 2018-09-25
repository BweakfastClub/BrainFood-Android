package club.bweakfast.foodora

import club.bweakfast.foodora.browse.category.CategoryName
import club.bweakfast.foodora.recipe.Recipe
import club.bweakfast.foodora.recipe.ingredient.Ingredient
import club.bweakfast.foodora.recipe.nutrition.NutritionValue

val breakfastRecipes = listOf(Recipe(
    25449,
    listOf(
        Ingredient(2882, "2 cups soy sauce", 512.0f, "Normal"),
        Ingredient(18888, "1 cup red wine vinegar", 257.14285f, "Normal"),
        Ingredient(16406, "1/4 teaspoon ground black pepper", 0.525f, "Normal"),
        Ingredient(5593, "3 drops hot pepper sauce", 2.82f, "Normal"),
        Ingredient(4378, "2 pounds whole fresh mushrooms", 908.0f, "Normal")
    ),
    "Deb's Spicy Summer Evening Mushrooms",
    8,
    5,
    10,
    -1,
    "https://images.media-allrecipes.com/userphotos/1017962.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 67.67107f, "kcal", "68", null, false),
        "fat" to NutritionValue("Fat", 0.4163184f, "g", "0.4", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 0.0f, "mg", "0", null, false),
        "sodium" to NutritionValue("Sodium", 3615.615f, "mg", "3616", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 10.78141f, "g", "10.8", null, false),
        "protein" to NutritionValue("Protein", 7.538084f, "g", "7.5", null, false),
        "folate" to NutritionValue("Folate", 27.13009f, "mcg", "27", null, false),
        "magnesium" to NutritionValue("Magnesium", 37.90461f, "mg", "38", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.213526f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 7.063933f, "mg", "7", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1247343f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.825728f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 15.89408f, "mg", "16", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 2.413144f, "mg", "2", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 5.977219f, "IU", "6", null, false),
        "sugars" to NutritionValue("Sugars", 2.961628f, "g", "3", null, false),
        "potassium" to NutritionValue("Potassium", 533.2303f, "mg", "533", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 0.05302178f, "g", "0.1", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 3.746865f, "kcal", "4", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.666506f, "g", "1.7", null, false)
    )
}, Recipe(
    237491,
    listOf(
        Ingredient(16133, "1 cup chicken broth", 198.0f, "Normal"),
        Ingredient(16248, "2 pounds shredded American cheese", 908.0f, "Normal"),
        Ingredient(6307, "1 tablespoon olive oil", 13.5f, "Normal"),
        Ingredient(6494, "2 skinless, boneless chicken breast halves - cut into cubes", 236.0f, "Normal"),
        Ingredient(5821, "3 links Mexican chorizo, casing removed and meat crumbled", 180.0f, "Normal"),
        Ingredient(4378, "1 (10 ounce) package sliced button mushrooms", 280.0f, "Normal"),
        Ingredient(4572, "2 tomatoes, seeded and diced", 296.0f, "Normal"),
        Ingredient(4397, "1/2 yellow onion, diced", 113.5f, "Normal"),
        Ingredient(3725, "2 jalapenos, seeded and diced", 28.0f, "Normal"),
        Ingredient(4405, "2 green onions, diced", 30.0f, "Normal"),
        Ingredient(4342, "1 clove garlic, or to taste, minced", 3.0f, "Normal"),
        Ingredient(16215, "8 ounces shredded Cheddar cheese", 226.8f, "Normal")
    ),
    "Loaded Queso Fundido",
    8,
    15,
    20,
    -1,
    "https://images.media-allrecipes.com/userphotos/1810432.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 718.8193f, "kcal", "719", null, false),
        "fat" to NutritionValue("Fat", 56.3928f, "g", "56.4", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 174.855f, "mg", "175", null, false),
        "sodium" to NutritionValue("Sodium", 2284.446f, "mg", "2284", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 7.352343f, "g", "7.4", null, false),
        "protein" to NutritionValue("Protein", 46.05419f, "g", "46.1", null, false),
        "folate" to NutritionValue("Folate", 33.32487f, "mcg", "33", null, false),
        "magnesium" to NutritionValue("Magnesium", 58.903f, "mg", "59", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.4549378f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 15.68183f, "mg", "16", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.2627932f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.391849f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 847.6423f, "mg", "848", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 8.856376f, "mg", "9", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 1753.224f, "IU", "1753", null, false),
        "sugars" to NutritionValue("Sugars", 3.208681f, "g", "3.2", null, false),
        "potassium" to NutritionValue("Potassium", 602.7574f, "mg", "603", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 32.09063f, "g", "32.1", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 507.5352f, "kcal", "508", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.232927f, "g", "1.2", null, false)
    )
}, Recipe(
    246256,
    listOf(
        Ingredient(5375, "4 strips bacon", 113.6f, "Normal"),
        Ingredient(0, "Dipping Sauce:", 0.0f, "Heading"),
        Ingredient(16223, "1/2 cup cream cheese, softened", 116.0f, "Normal"),
        Ingredient(20573, "1/4 cup creme fraiche or sour cream", 57.0f, "Normal"),
        Ingredient(4405, "2 tablespoons minced green onions, plus some for garnish", 12.0f, "Normal"),
        Ingredient(5112, "1 teaspoon fresh lime juice", 5.125f, "Normal"),
        Ingredient(0, "", 0.0f, "BlankLine"),
        Ingredient(0, "Dough:", 0.0f, "Heading"),
        Ingredient(2496, "2/3 cup water", 158.0f, "Normal"),
        Ingredient(16157, "3 tablespoons butter", 42.6f, "Normal"),
        Ingredient(7184, "1 tablespoon bacon fat", 14.0f, "Normal"),
        Ingredient(18866, "1 teaspoon kosher salt", 4.8f, "Normal"),
        Ingredient(1684, "2/3 cup all-purpose flour", 83.333336f, "Normal"),
        Ingredient(0, "", 0.0f, "BlankLine"),
        Ingredient(16317, "2 eggs", 100.0f, "Normal"),
        Ingredient(20474, "2 ounces shredded extra-sharp white Cheddar cheese", 56.7f, "Normal"),
        Ingredient(3725, "1/2 cup finely diced jalapeno peppers", 45.0f, "Normal"),
        Ingredient(16407, "1 pinch cayenne pepper", 0.2f, "Normal"),
        Ingredient(16406, "1 pinch freshly ground black pepper", 1.0f, "Normal"),
        Ingredient(20482, "2 cups vegetable oil for deep frying, or as needed", 440.0f, "Normal")
    ),
    "Bacon Jalapeno Popper Puffs",
    8,
    15,
    30,
    -1,
    "https://images.media-allrecipes.com/userphotos/3345433.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 290.6031f, "kcal", "291", null, false),
        "fat" to NutritionValue("Fat", 25.08788f, "g", "25.1", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 98.26211f, "mg", "98", null, false),
        "sodium" to NutritionValue("Sodium", 488.2495f, "mg", "488", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 9.436511f, "g", "9.4", null, false),
        "protein" to NutritionValue("Protein", 7.643674f, "g", "7.6", null, false),
        "folate" to NutritionValue("Folate", 32.07149f, "mcg", "32", null, false),
        "magnesium" to NutritionValue("Magnesium", 10.16132f, "mg", "10", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.08159002f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 2.223676f, "mg", "2", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1354421f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.10212f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 75.60432f, "mg", "76", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 3.011412f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 536.8799f, "IU", "537", null, false),
        "sugars" to NutritionValue("Sugars", 0.6436284f, "g", "0.6", null, false),
        "potassium" to NutritionValue("Potassium", 98.79222f, "mg", "99", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 11.62264f, "g", "11.6", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 225.791f, "kcal", "226", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.51118f, "g", "0.5", null, false)
    )
}, Recipe(
    51147,
    listOf(
        Ingredient(3103, "1 pound ground beef", 454.0f, "Normal"),
        Ingredient(18765, "1 (1.25 ounce) package taco seasoning mix", 35.5f, "Normal"),
        Ingredient(2496, "3/4 cup water", 177.75f, "Normal"),
        Ingredient(1320, "1 (18 ounce) package restaurant-style tortilla chips", 504.0f, "Normal"),
        Ingredient(16215, "1 cup shredded sharp Cheddar cheese, or more to taste", 113.0f, "Normal"),
        Ingredient(2863, "1 (15.5 ounce) can refried beans", 434.0f, "Normal"),
        Ingredient(5588, "1 cup salsa", 259.0f, "Normal"),
        Ingredient(16261, "1 cup sour cream, or more to taste", 230.0f, "Normal"),
        Ingredient(5133, "1 (10 ounce) can pitted black olives, drained and chopped", 280.0f, "Normal"),
        Ingredient(4405, "4 green onions, diced", 60.0f, "Normal"),
        Ingredient(4634, "1 (4 ounce) can sliced jalapeno peppers, drained", 112.0f, "Normal")
    ),
    "Super Nachos",
    12,
    30,
    20,
    -1,
    "https://images.media-allrecipes.com/userphotos/829002.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 432.1232f, "kcal", "432", null, false),
        "fat" to NutritionValue("Fat", 24.45912f, "g", "24.5", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 44.1625f, "mg", "44", null, false),
        "sodium" to NutritionValue("Sodium", 1081.15f, "mg", "1081", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 39.71766f, "g", "39.7", null, false),
        "protein" to NutritionValue("Protein", 15.23602f, "g", "15.2", null, false),
        "folate" to NutritionValue("Folate", 23.89333f, "mcg", "24", null, false),
        "magnesium" to NutritionValue("Magnesium", 89.87063f, "mg", "90", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.2750925f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 4.839902f, "mg", "5", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.07597917f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 3.403642f, "mg", "3", null, false),
        "calcium" to NutritionValue("Calcium", 211.4619f, "mg", "211", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 4.835917f, "mg", "5", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 585.3884f, "IU", "585", null, false),
        "sugars" to NutritionValue("Sugars", 2.057296f, "g", "2.1", null, false),
        "potassium" to NutritionValue("Potassium", 399.3673f, "mg", "399", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 7.93238f, "g", "7.9", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 220.132f, "kcal", "220", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 5.6075f, "g", "5.6", null, false)
    )
}, Recipe(
    241000,
    listOf(
        Ingredient(0, "Cheese Sauce:", 0.0f, "Heading"),
        Ingredient(16157, "2 tablespoons butter, or as needed", 28.4f, "Normal"),
        Ingredient(1684, "2 tablespoons all-purpose flour, or as needed", 15.625f, "Normal"),
        Ingredient(16278, "1 cup cold milk", 244.0f, "Normal"),
        Ingredient(16241, "2 ounces shredded provolone cheese, or more to taste", 56.7f, "Normal"),
        Ingredient(16401, "1 pinch ground nutmeg", 1.0f, "Normal"),
        Ingredient(16407, "1 pinch cayenne pepper", 0.2f, "Normal"),
        Ingredient(16421, "salt to taste", 0.4f, "HideAmounts"),
        Ingredient(0, "", 0.0f, "BlankLine"),
        Ingredient(26706, "1 (12 ounce) skirt steak", 340.0f, "Normal"),
        Ingredient(16421, "salt and freshly ground black pepper to taste", 0.4f, "HideAmounts"),
        Ingredient(6307, "3 tablespoons olive oil, divided, or as needed", 40.5f, "Normal"),
        Ingredient(2496, "1/4 cup water", 59.25f, "Normal"),
        Ingredient(4397, "1/3 cup diced onion", 53.333336f, "Normal"),
        Ingredient(4786, "1/3 cup diced sweet peppers", 51.90167f, "Normal"),
        Ingredient(20414, "2 baguettes, or as needed, cut into 48 1/2-inch thick slices", 680.0f, "Normal"),
        Ingredient(16241, "1/4 cup shredded provolone cheese, or as needed", 33.0f, "Normal")
    ),
    "Mini Philly Cheesesteaks",
    12,
    30,
    30,
    -1,
    "https://images.media-allrecipes.com/userphotos/2805818.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 280.2366f, "kcal", "280", null, false),
        "fat" to NutritionValue("Fat", 9.933566f, "g", "9.9", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 18.16275f, "mg", "18", null, false),
        "sodium" to NutritionValue("Sodium", 488.7691f, "mg", "489", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 34.8157f, "g", "34.8", null, false),
        "protein" to NutritionValue("Protein", 12.89247f, "g", "12.9", null, false),
        "folate" to NutritionValue("Folate", 92.10966f, "mcg", "92", null, false),
        "magnesium" to NutritionValue("Magnesium", 24.4348f, "mg", "24", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.1566652f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 5.860651f, "mg", "6", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.3317542f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 2.435745f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 109.9185f, "mg", "110", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 6.021325f, "mg", "6", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 305.882f, "IU", "306", null, false),
        "sugars" to NutritionValue("Sugars", 2.836842f, "g", "2.8", null, false),
        "potassium" to NutritionValue("Potassium", 171.8475f, "mg", "172", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 3.996346f, "g", "4", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 89.40209f, "kcal", "89", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.579514f, "g", "1.6", null, false)
    )
}, Recipe(
    237835,
    listOf(
        Ingredient(10536, "cooking spray", 0.266f, "HideAmounts"),
        Ingredient(16157, "2 tablespoons butter, melted", 28.4f, "Normal"),
        Ingredient(
            2061,
            "1 (16.3 ounce) package refrigerated buttermilk biscuit dough, separated and each portion cut into quarters",
            456.4f,
            "Normal"
        ),
        Ingredient(16215, "1 1/4 cups shredded Cheddar cheese, divided", 141.25f, "Normal"),
        Ingredient(3725, "3/4 cup jalapeno pepper slices, divided", 67.5f, "Normal"),
        Ingredient(16405, "3/4 teaspoon dried parsley flakes, divided", 0.3441735f, "Normal"),
        Ingredient(16234, "1/4 cup shredded mozzarella cheese", 28.25f, "Normal")
    ),
    "Big Ray's Mexican Monkey Bread",
    12,
    10,
    40,
    -1,
    "https://images.media-allrecipes.com/userphotos/2336354.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 194.819f, "kcal", "195", null, false),
        "fat" to NutritionValue("Fat", 11.4375f, "g", "11.4", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 19.33471f, "mg", "19", null, false),
        "sodium" to NutritionValue("Sodium", 481.4401f, "mg", "481", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 17.02101f, "g", "17", null, false),
        "protein" to NutritionValue("Protein", 6.137563f, "g", "6.1", null, false),
        "folate" to NutritionValue("Folate", 26.776f, "mcg", "27", null, false),
        "magnesium" to NutritionValue("Magnesium", 11.49046f, "mg", "11", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.06325272f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 2.462035f, "mg", "2", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1636225f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.096363f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 124.2258f, "mg", "124", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 2.526866f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 239.3176f, "IU", "239", null, false),
        "sugars" to NutritionValue("Sugars", 3.089215f, "g", "3.1", null, false),
        "potassium" to NutritionValue("Potassium", 88.87998f, "mg", "89", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 5.278427f, "g", "5.3", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 102.9375f, "kcal", "103", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.4233949f, "g", "0.4", null, false)
    )
}, Recipe(
    22617,
    listOf(
        Ingredient(6294, "1 cup mayonnaise", 220.0f, "Normal"),
        Ingredient(16261, "1 (16 ounce) container sour cream", 454.4f, "Normal"),
        Ingredient(5528, "1 (1.8 ounce) package dry leek soup mix", 50.4f, "Normal"),
        Ingredient(4607, "1 (4 ounce) can water chestnuts, drained and chopped", 28.0f, "Normal"),
        Ingredient(
            4520,
            "1/2 (10 ounce) package frozen chopped spinach, thawed and drained",
            142.0f,
            "Normal"
        ),
        Ingredient(20487, "1 (1 pound) loaf round sourdough bread", 448.0f, "Normal")
    ),
    "Best Spinach Dip Ever",
    6,
    15,
    0,
    -1,
    "https://images.media-allrecipes.com/userphotos/748478.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 681.9874f, "kcal", "682", null, false),
        "fat" to NutritionValue("Fat", 47.40307f, "g", "47.4", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 48.264f, "mg", "48", null, false),
        "sodium" to NutritionValue("Sodium", 1183.385f, "mg", "1183", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 53.21023f, "g", "53.2", null, false),
        "protein" to NutritionValue("Protein", 13.34167f, "g", "13.3", null, false),
        "folate" to NutritionValue("Folate", 159.0473f, "mcg", "159", null, false),
        "magnesium" to NutritionValue("Magnesium", 52.12333f, "mg", "52", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.3548774f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 6.392315f, "mg", "6", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.4603666f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 3.500807f, "mg", "4", null, false),
        "calcium" to NutritionValue("Calcium", 168.0153f, "mg", "168", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 3.453267f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 3371.008f, "IU", "3371", null, false),
        "sugars" to NutritionValue("Sugars", 2.697273f, "g", "2.7", null, false),
        "potassium" to NutritionValue("Potassium", 336.3227f, "mg", "336", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 15.07642f, "g", "15.1", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 426.6277f, "kcal", "427", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 2.8974f, "g", "2.9", null, false)
    )
}, Recipe(
    231170,
    listOf(
        Ingredient(16223, "2 (8 ounce) packages cream cheese, softened", 448.0f, "Normal"),
        Ingredient(2740, "1 pound lump crabmeat, drained", 454.0f, "Normal"),
        Ingredient(126, "1 (14 ounce) can artichoke bottoms, drained and chopped", 240.0f, "Normal"),
        Ingredient(16215, "6 ounces shredded white Cheddar cheese", 170.1f, "Normal"),
        Ingredient(4786, "1/2 cup finely diced red bell pepper", 74.5f, "Normal"),
        Ingredient(4405, "1/3 cup chopped green onions", 33.333332f, "Normal"),
        Ingredient(16261, "1/2 cup sour cream", 115.0f, "Normal"),
        Ingredient(6294, "1/4 cup mayonnaise", 55.0f, "Normal"),
        Ingredient(4342, "3 cloves garlic, minced", 9.0f, "Normal"),
        Ingredient(5106, "1 lemon, zested and juiced", 112.0f, "Normal"),
        Ingredient(18774, "2 teaspoons chopped fresh tarragon", 4.0f, "Normal"),
        Ingredient(7428, "1 teaspoon Worcestershire sauce", 5.6666665f, "Normal"),
        Ingredient(16407, "1 pinch cayenne pepper, or more to taste", 0.2f, "Normal"),
        Ingredient(16421, "salt and freshly ground black pepper to taste", 0.4f, "HideAmounts"),
        Ingredient(20487, "1 round loaf sourdough bread", 454.0f, "Normal"),
        Ingredient(16215, "2 tablespoons shredded white Cheddar cheese", 16.638655f, "Normal")
    ),
    "Baked Crab and Artichoke Dip",
    12,
    30,
    30,
    -1,
    "https://images.media-allrecipes.com/userphotos/1866265.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 414.4747f, "kcal", "414", null, false),
        "fat" to NutritionValue("Fat", 25.04629f, "g", "25", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 92.11797f, "mg", "92", null, false),
        "sodium" to NutritionValue("Sodium", 754.3748f, "mg", "754", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 27.5489f, "g", "27.5", null, false),
        "protein" to NutritionValue("Protein", 20.92701f, "g", "20.9", null, false),
        "folate" to NutritionValue("Folate", 86.18597f, "mcg", "86", null, false),
        "magnesium" to NutritionValue("Magnesium", 43.09868f, "mg", "43", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.1999312f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 7.323806f, "mg", "7", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.2440474f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 2.277903f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 203.0533f, "mg", "203", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 20.04706f, "mg", "20", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 1078.478f, "IU", "1078", null, false),
        "sugars" to NutritionValue("Sugars", 1.559838f, "g", "1.6", null, false),
        "potassium" to NutritionValue("Potassium", 319.7342f, "mg", "320", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 13.53696f, "g", "13.5", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 225.4166f, "kcal", "225", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 2.278245f, "g", "2.3", null, false)
    )
}, Recipe(
    234476,
    listOf(
        Ingredient(10536, "cooking spray", 0.266f, "HideAmounts"),
        Ingredient(3103, "1 pound ground beef", 454.0f, "Normal"),
        Ingredient(2863, "2 (16 ounce) cans refried beans", 896.0f, "Normal"),
        Ingredient(578, "4 cups shredded Colby-Monterey Jack cheese, divided", 540.0f, "Normal"),
        Ingredient(16261, "1 cup sour cream", 230.0f, "Normal"),
        Ingredient(16223, "1 (4 ounce) package cream cheese, softened", 113.0f, "Normal"),
        Ingredient(18765, "1 (1.25 ounce) package taco seasoning mix", 35.5f, "Normal")
    ),
    "Cheesy Burrito Game Day Dip",
    8,
    15,
    30,
    -1,
    "https://images.media-allrecipes.com/userphotos/1119769.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 595.299f, "kcal", "595", null, false),
        "fat" to NutritionValue("Fat", 41.00536f, "g", "41", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 137.9463f, "mg", "138", null, false),
        "sodium" to NutritionValue("Sodium", 1270.585f, "mg", "1271", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 24.18284f, "g", "24.2", null, false),
        "protein" to NutritionValue("Protein", 32.91967f, "g", "32.9", null, false),
        "folate" to NutritionValue("Folate", 20.83125f, "mcg", "21", null, false),
        "magnesium" to NutritionValue("Magnesium", 48.6975f, "mg", "49", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.2767738f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 6.008617f, "mg", "6", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.05675375f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 3.008375f, "mg", "3", null, false),
        "calcium" to NutritionValue("Calcium", 88.065f, "mg", "88", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 6.97875f, "mg", "7", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 376.4225f, "IU", "376", null, false),
        "sugars" to NutritionValue("Sugars", 1.072769f, "g", "1.1", null, false),
        "potassium" to NutritionValue("Potassium", 472.1075f, "mg", "472", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 25.31359f, "g", "25.3", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 369.0482f, "kcal", "369", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 5.936f, "g", "5.9", null, false)
    )
}, Recipe(
    237562,
    listOf(
        Ingredient(2496, "2 cups water, or as needed", 474.0f, "Normal"),
        Ingredient(16317, "8 fresh eggs", 400.0f, "Normal"),
        Ingredient(0, "", 0.0f, "BlankLine"),
        Ingredient(2496, "4 cups cold water", 948.0f, "Normal"),
        Ingredient(20382, "4 cups ice cubes", 948.0f, "Normal")
    ),
    "Pressure Cooker Hard-Boiled Eggs",
    4,
    5,
    6,
    -1,
    "https://images.media-allrecipes.com/userphotos/3603605.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 143.0f, "kcal", "143", null, false),
        "fat" to NutritionValue("Fat", 9.94f, "g", "9.9", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 372.0f, "mg", "372", null, false),
        "sodium" to NutritionValue("Sodium", 157.775f, "mg", "158", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 0.77f, "g", "0.8", null, false),
        "protein" to NutritionValue("Protein", 12.58f, "g", "12.6", null, false),
        "folate" to NutritionValue("Folate", 47.0f, "mcg", "47", null, false),
        "magnesium" to NutritionValue("Magnesium", 17.925f, "mg", "18", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.143f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 2.788715f, "mg", "3", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.062f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.83f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 70.77499f, "mg", "71", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.0f, "mg", "0", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 487.0f, "IU", "487", null, false),
        "sugars" to NutritionValue("Sugars", 0.77f, "g", "0.8", null, false),
        "potassium" to NutritionValue("Potassium", 139.925f, "mg", "140", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 3.099f, "g", "3.1", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 89.46f, "kcal", "89", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.0f, "g", "0", null, false)
    )
})
val lunchRecipes = listOf(Recipe(
    16700,
    listOf(
        Ingredient(6494, "4 skinless, boneless chicken breast halves", 472.0f, "Normal"),
        Ingredient(18765, "4 teaspoons taco seasoning mix", 12.0f, "Normal"),
        Ingredient(5588, "1 cup salsa", 259.0f, "Normal"),
        Ingredient(16215, "1 cup shredded Cheddar cheese", 113.0f, "Normal"),
        Ingredient(16261, "2 tablespoons sour cream (optional)", 28.75f, "OptionalIngredient")
    ),
    "Salsa Chicken",
    4,
    5,
    40,
    -1,
    "https://images.media-allrecipes.com/userphotos/4487510.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 286.6807f, "kcal", "287", null, false),
        "fat" to NutritionValue("Fat", 12.43535f, "g", "12.4", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 101.265f, "mg", "101", null, false),
        "sodium" to NutritionValue("Sodium", 863.0859f, "mg", "863", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 6.755754f, "g", "6.8", null, false),
        "protein" to NutritionValue("Protein", 35.50472f, "g", "35.5", null, false),
        "folate" to NutritionValue("Folate", 13.18563f, "mcg", "13", null, false),
        "magnesium" to NutritionValue("Magnesium", 51.45312f, "mg", "51", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.7843675f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 20.18241f, "mg", "20", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1186431f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.343863f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 242.4825f, "mg", "242", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 2.710938f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 543.49f, "IU", "543", null, false),
        "sugars" to NutritionValue("Sugars", 2.648225f, "g", "2.6", null, false),
        "potassium" to NutritionValue("Potassium", 531.2425f, "mg", "531", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 7.303926f, "g", "7.3", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 111.9181f, "kcal", "112", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.036f, "g", "1", null, false)
    )
}, Recipe(
    232279,
    listOf(
        Ingredient(1636, "2 tablespoons cornstarch", 16.0f, "Normal"),
        Ingredient(2496, "1 1/2 tablespoons water", 22.1775f, "Normal"),
        Ingredient(16133, "6 cups chicken broth", 1188.0f, "Normal"),
        Ingredient(2882, "2 1/2 tablespoons soy sauce", 40.0f, "Normal"),
        Ingredient(5597, "1 tablespoon fish sauce", 14.175f, "Normal"),
        Ingredient(18868, "1 tablespoon rice vinegar", 15.884933f, "Normal"),
        Ingredient(
            12057,
            "1 tablespoon chile-garlic sauce (such as SrirachaÂ®), or more to taste",
            16.0f,
            "Normal"
        ),
        Ingredient(6305, "2 teaspoons vegetable oil", 9.083333f, "Normal"),
        Ingredient(4343, "2 teaspoons minced fresh ginger root", 3.73332f, "Normal"),
        Ingredient(4342, "2 cloves garlic, minced", 6.0f, "Normal"),
        Ingredient(18844, "1 teaspoon ground coriander", 2.0f, "Normal"),
        Ingredient(1728, "1 (16 ounce) package thick rice noodles", 448.0f, "Normal"),
        Ingredient(4529, "1 cup sliced zucchini", 113.0f, "Normal"),
        Ingredient(4786, "1 cup sliced red bell pepper", 92.0f, "Normal"),
        Ingredient(6496, "2 cooked chicken breasts, cut into 1-inch cubes", 172.0f, "Normal"),
        Ingredient(2850, "1/4 cup crushed peanuts (optional)", 35.55f, "OptionalIngredient"),
        Ingredient(3717, "1/4 cup chopped fresh cilantro (optional)", 11.5f, "OptionalIngredient")
    ),
    "One Pot Thai-Style Rice Noodles",
    4,
    20,
    15,
    -1,
    "https://images.media-allrecipes.com/userphotos/2458255.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 586.8317f, "kcal", "587", null, false),
        "fat" to NutritionValue("Fat", 9.182344f, "g", "9.2", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 29.6375f, "mg", "30", null, false),
        "sodium" to NutritionValue("Sodium", 2736.326f, "mg", "2736", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 104.9318f, "g", "104.9", null, false),
        "protein" to NutritionValue("Protein", 17.42097f, "g", "17.4", null, false),
        "folate" to NutritionValue("Folate", 41.01935f, "mcg", "41", null, false),
        "magnesium" to NutritionValue("Magnesium", 55.74534f, "mg", "56", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.3160773f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 7.559557f, "mg", "8", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1296284f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.919197f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 46.65498f, "mg", "47", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 35.93713f, "mg", "36", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 1101.908f, "IU", "1102", null, false),
        "sugars" to NutritionValue("Sugars", 3.639694f, "g", "3.6", null, false),
        "potassium" to NutritionValue("Potassium", 325.3358f, "mg", "325", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 1.404997f, "g", "1.4", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 82.6411f, "kcal", "83", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 3.912717f, "g", "3.9", null, false)
    )
}, Recipe(
    261479,
    listOf(
        Ingredient(6306, "2 tablespoons coconut oil", 27.2f, "Normal"),
        Ingredient(
            6494,
            "1 (16 ounce) package skinless, boneless chicken breast halves, cut into small cubes",
            453.6f,
            "Normal"
        ),
        Ingredient(
            3793,
            "1 (14 ounce) can cream of coconut (such as Trader Joe'sÂ® Extra Thick and Rich)",
            392.0f,
            "Normal"
        ),
        Ingredient(
            12049,
            "1 (11 ounce) bottle red Thai curry sauce (such as Trader Joe'sÂ®)",
            312.4f,
            "Normal"
        ),
        Ingredient(17518, "1/2 (16 ounce) package dried rice stick vermicelli noodles", 226.8f, "Normal")
    ),
    "Four-Ingredient Red Curry Chicken",
    6,
    10,
    19,
    -1,
    "https://images.media-allrecipes.com/userphotos/3949345.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 530.9652f, "kcal", "531", null, false),
        "fat" to NutritionValue("Fat", 19.51937f, "g", "19.5", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 42.925f, "mg", "43", null, false),
        "sodium" to NutritionValue("Sodium", 238.3176f, "mg", "238", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 67.43088f, "g", "67.4", null, false),
        "protein" to NutritionValue("Protein", 20.43284f, "g", "20.4", null, false),
        "folate" to NutritionValue("Folate", 13.61999f, "mcg", "14", null, false),
        "magnesium" to NutritionValue("Magnesium", 27.1409f, "mg", "27", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.3297007f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 10.87153f, "mg", "11", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.04972333f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 2.201133f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 32.9784f, "mg", "33", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.02773893f, "mg", "< 1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 110.7481f, "IU", "111", null, false),
        "sugars" to NutritionValue("Sugars", 33.76301f, "g", "33.8", null, false),
        "potassium" to NutritionValue("Potassium", 241.9959f, "mg", "242", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 14.98295f, "g", "15", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 175.6743f, "kcal", "176", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.181578f, "g", "1.2", null, false)
    )
}, Recipe(
    246274,
    listOf(
        Ingredient(20384, "2 (3 1/2) pound whole chickens, wingtips removed", 3178.0f, "Normal"),
        Ingredient(16421, "2 teaspoons salt", 12.0f, "Normal"),
        Ingredient(18710, "1 teaspoon dried tarragon", 1.6f, "Normal"),
        Ingredient(16404, "1 teaspoon paprika", 2.2808332f, "Normal"),
        Ingredient(16406, "1/4 teaspoon black pepper", 0.525f, "Normal"),
        Ingredient(6307, "4 teaspoons olive oil", 19.030836f, "Normal"),
        Ingredient(5106, "2 lemons, thinly sliced and seeded", 0.0f, "Normal")
    ),
    "Spatchcock Chicken",
    8,
    10,
    35,
    -1,
    "https://images.media-allrecipes.com/userphotos/3616309.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 545.4479f, "kcal", "545", null, false),
        "fat" to NutritionValue("Fat", 32.07438f, "g", "32.1", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 239.0113f, "mg", "239", null, false),
        "sodium" to NutritionValue("Sodium", 758.1497f, "mg", "758", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 0.4384736f, "g", "0.4", null, false),
        "protein" to NutritionValue("Protein", 59.9171f, "g", "59.9", null, false),
        "folate" to NutritionValue("Folate", 65.08752f, "mcg", "65", null, false),
        "magnesium" to NutritionValue("Magnesium", 52.04601f, "mg", "52", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.8605093f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 28.82102f, "mg", "29", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1426367f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 3.883892f, "mg", "4", null, false),
        "calcium" to NutritionValue("Calcium", 37.28146f, "mg", "37", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 1.333365f, "mg", "1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 1579.611f, "IU", "1580", null, false),
        "sugars" to NutritionValue("Sugars", 0.02989977f, "g", "0", null, false),
        "potassium" to NutritionValue("Potassium", 487.6078f, "mg", "488", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 8.599978f, "g", "8.6", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 288.6694f, "kcal", "289", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.1376196f, "g", "0.1", null, false)
    )
}, Recipe(
    261536,
    listOf(
        Ingredient(10536, "cooking spray", 0.266f, "HideAmounts"),
        Ingredient(2351, "10 (6 inch) corn tortillas, cut into quarters", 260.0f, "Normal"),
        Ingredient(16215, "1 (8 ounce) package sharp Cheddar cheese, cubed", 224.0f, "Normal"),
        Ingredient(4397, "1 onion, chopped", 110.0f, "Normal"),
        Ingredient(5133, "1 (3.8 ounce) can sliced black olives", 107.73f, "Normal"),
        Ingredient(7432, "1 (16 ounce) can green chile enchilada sauce", 480.0f, "Normal"),
        Ingredient(445, "2 cups shredded Mexican cheese blend", 267.2f, "Normal")
    ),
    "Cheesy Vegetarian Enchilada Casserole",
    6,
    10,
    25,
    -1,
    "https://images.media-allrecipes.com/userphotos/4558217.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 505.5183f, "kcal", "506", null, false),
        "fat" to NutritionValue("Fat", 34.57152f, "g", "34.6", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 96.16397f, "mg", "96", null, false),
        "sodium" to NutritionValue("Sodium", 762.9247f, "mg", "763", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 28.33794f, "g", "28.3", null, false),
        "protein" to NutritionValue("Protein", 23.3584f, "g", "23.4", null, false),
        "folate" to NutritionValue("Folate", 16.614f, "mcg", "17", null, false),
        "magnesium" to NutritionValue("Magnesium", 57.43687f, "mg", "57", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.2069426f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 3.814575f, "mg", "4", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.06685198f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.795482f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 636.3823f, "mg", "636", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 8.919862f, "mg", "9", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 1275.528f, "IU", "1276", null, false),
        "sugars" to NutritionValue("Sugars", 1.3528f, "g", "1.4", null, false),
        "potassium" to NutritionValue("Potassium", 354.2237f, "mg", "354", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 20.98672f, "g", "21", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 311.1437f, "kcal", "311", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 4.841827f, "g", "4.8", null, false)
    )
}, Recipe(
    240400,
    listOf(
        Ingredient(4397, "1/4 cup chopped onion", 40.0f, "Normal"),
        Ingredient(2882, "5 tablespoons soy sauce", 80.0f, "Normal"),
        Ingredient(1525, "2 1/2 tablespoons brown sugar", 33.920704f, "Normal"),
        Ingredient(4342, "2 tablespoons minced garlic", 16.77533f, "Normal"),
        Ingredient(6309, "2 tablespoons sesame oil", 27.2f, "Normal"),
        Ingredient(3752, "1 tablespoon sesame seeds", 9.0f, "Normal"),
        Ingredient(16407, "1/2 teaspoon cayenne", 0.9f, "Normal"),
        Ingredient(16421, "salt and ground black pepper to taste", 0.4f, "HideAmounts"),
        Ingredient(
            6494,
            "1 pound skinless, boneless chicken breasts, cut into thin strips",
            454.4f,
            "Normal"
        )
    ),
    "Skillet Chicken Bulgogi",
    4,
    15,
    15,
    -1,
    "https://images.media-allrecipes.com/userphotos/2280937.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 268.9135f, "kcal", "269", null, false),
        "fat" to NutritionValue("Fat", 11.575f, "g", "11.6", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 69.16f, "mg", "69", null, false),
        "sodium" to NutritionValue("Sodium", 1230.0f, "mg", "1230", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 13.20333f, "g", "13.2", null, false),
        "protein" to NutritionValue("Protein", 27.48325f, "g", "27.5", null, false),
        "folate" to NutritionValue("Folate", 10.37162f, "mcg", "10", null, false),
        "magnesium" to NutritionValue("Magnesium", 43.21217f, "mg", "43", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.6065582f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 17.26404f, "mg", "17", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.09884159f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.750159f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 55.18388f, "mg", "55", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 2.220376f, "mg", "2", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 111.8824f, "IU", "112", null, false),
        "sugars" to NutritionValue("Sugars", 9.06342f, "g", "9.1", null, false),
        "potassium" to NutritionValue("Potassium", 310.9254f, "mg", "311", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 2.1188f, "g", "2.1", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 104.175f, "kcal", "104", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.7447705f, "g", "0.7", null, false)
    )
}, Recipe(
    255462,
    listOf(
        Ingredient(16243, "1 (15 ounce) container ricotta cheese", 426.0f, "Normal"),
        Ingredient(16234, "1 (8 ounce) package shredded mozzarella cheese, divided", 224.0f, "Normal"),
        Ingredient(16238, "1 (3 ounce) package Parmesan cheese", 84.0f, "Normal"),
        Ingredient(16317, "1 egg", 50.0f, "Normal"),
        Ingredient(20245, "2 teaspoons Italian seasoning", 3.0f, "Normal"),
        Ingredient(5861, "1 pound sausage", 454.0f, "Normal"),
        Ingredient(5803, "1/2 (26 ounce) jar marinara sauce", 364.0f, "Normal"),
        Ingredient(28648, "6 flatbreads", 318.0f, "Normal")
    ),
    "Lasagna Flatbread",
    6,
    25,
    15,
    -1,
    "https://images.media-allrecipes.com/userphotos/4019381.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 601.8683f, "kcal", "602", null, false),
        "fat" to NutritionValue("Fat", 36.83162f, "g", "36.8", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 133.735f, "mg", "134", null, false),
        "sodium" to NutritionValue("Sodium", 1679.415f, "mg", "1679", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 30.5233f, "g", "30.5", null, false),
        "protein" to NutritionValue("Protein", 43.96232f, "g", "44", null, false),
        "folate" to NutritionValue("Folate", 28.20667f, "mcg", "28", null, false),
        "magnesium" to NutritionValue("Magnesium", 48.515f, "mg", "49", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.3422633f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 10.8063f, "mg", "11", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.4524117f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.981917f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 682.6633f, "mg", "683", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 2.506667f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 870.6851f, "IU", "871", null, false),
        "sugars" to NutritionValue("Sugars", 6.215517f, "g", "6.2", null, false),
        "potassium" to NutritionValue("Potassium", 537.15f, "mg", "537", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 16.03103f, "g", "16", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 331.4846f, "kcal", "331", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 10.79133f, "g", "10.8", null, false)
    )
}, Recipe(
    253161,
    listOf(
        Ingredient(2829, "1 cup lentils", 192.0f, "Normal"),
        Ingredient(4397, "2 onions, diced", 454.0f, "Normal"),
        Ingredient(4147, "1 pound lean ground beef", 454.0f, "Normal"),
        Ingredient(4432, "1 large green bell pepper, diced", 164.0f, "Normal"),
        Ingredient(3686, "3/4 cup ketchup", 180.0f, "Normal"),
        Ingredient(16169, "3/4 cup barbeque sauce", 187.5f, "Normal"),
        Ingredient(7428, "1 tablespoon Worcestershire sauce", 17.0f, "Normal"),
        Ingredient(4342, "1 tablespoon minced garlic", 8.387665f, "Normal")
    ),
    "Andie's Quick 'n Easy Sneaky Sloppy Joes",
    8,
    10,
    46,
    -1,
    "https://images.media-allrecipes.com/userphotos/4398244.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 280.0972f, "kcal", "280", null, false),
        "fat" to NutritionValue("Fat", 7.402349f, "g", "7.4", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 37.16875f, "mg", "37", null, false),
        "sodium" to NutritionValue("Sodium", 572.2826f, "mg", "572", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 35.58584f, "g", "35.6", null, false),
        "protein" to NutritionValue("Protein", 18.23358f, "g", "18.2", null, false),
        "folate" to NutritionValue("Folate", 134.6252f, "mcg", "135", null, false),
        "magnesium" to NutritionValue("Magnesium", 53.62962f, "mg", "54", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.4249028f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 6.633214f, "mg", "7", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.2039932f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 3.263193f, "mg", "3", null, false),
        "calcium" to NutritionValue("Calcium", 43.88021f, "mg", "44", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 25.90243f, "mg", "26", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 353.1212f, "IU", "353", null, false),
        "sugars" to NutritionValue("Sugars", 14.84008f, "g", "14.8", null, false),
        "potassium" to NutritionValue("Potassium", 636.8593f, "mg", "637", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 2.799048f, "g", "2.8", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 66.62114f, "kcal", "67", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 8.863392f, "g", "8.9", null, false)
    )
}, Recipe(
    247285,
    listOf(
        Ingredient(2633, "1 pound fresh speckled trout", 454.0f, "Normal"),
        Ingredient(16157, "2 tablespoons butter", 28.4f, "Normal"),
        Ingredient(18845, "1 tablespoon lemon pepper", 6.0125f, "Normal"),
        Ingredient(16427, "1 teaspoon capers", 2.8666666f, "Normal"),
        Ingredient(16404, "1 pinch paprika, or to taste", 1.0f, "Normal"),
        Ingredient(3474, "1/4 cup white cooking wine", 62.480736f, "Normal"),
        Ingredient(4409, "1 teaspoon minced fresh parsley, or to taste", 1.25f, "Normal")
    ),
    "Speckled Trout in Capers and White Wine",
    2,
    10,
    30,
    -1,
    "https://images.media-allrecipes.com/userphotos/4505375.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 398.5623f, "kcal", "399", null, false),
        "fat" to NutritionValue("Fat", 21.94989f, "g", "21.9", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 152.66f, "mg", "153", null, false),
        "sodium" to NutritionValue("Sodium", 918.118f, "mg", "918", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 1.830213f, "g", "1.8", null, false),
        "protein" to NutritionValue("Protein", 40.91334f, "g", "40.9", null, false),
        "folate" to NutritionValue("Folate", 36.17808f, "mcg", "36", null, false),
        "magnesium" to NutritionValue("Magnesium", 61.25447f, "mg", "61", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.6494583f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 17.97053f, "mg", "18", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.2750201f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.094376f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 164.8279f, "mg", "165", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 4.843729f, "mg", "5", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 762.4528f, "IU", "762", null, false),
        "sugars" to NutritionValue("Sugars", 0.6597062f, "g", "0.7", null, false),
        "potassium" to NutritionValue("Potassium", 843.23f, "mg", "843", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 10.18157f, "g", "10.2", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 197.549f, "kcal", "198", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.3998359f, "g", "0.4", null, false)
    )
}, Recipe(
    229960,
    listOf(
        Ingredient(17673, "1 (16 ounce) package linguine pasta", 448.0f, "Normal"),
        Ingredient(16157, "2 tablespoons butter", 28.4f, "Normal"),
        Ingredient(9725, "2 tablespoons extra-virgin olive oil", 27.0f, "Normal"),
        Ingredient(4663, "2 shallots, finely diced", 100.0f, "Normal"),
        Ingredient(4342, "2 cloves garlic, minced", 6.0f, "Normal"),
        Ingredient(20244, "1 pinch red pepper flakes (optional)", 1.0f, "OptionalIngredient"),
        Ingredient(2664, "1 pound shrimp, peeled and deveined", 454.0f, "Normal"),
        Ingredient(18866, "1 pinch kosher salt and freshly ground pepper", 1.0f, "Normal"),
        Ingredient(3474, "1/2 cup dry white wine", 124.96147f, "Normal"),
        Ingredient(5107, "1 lemon, juiced", 45.0f, "Normal"),
        Ingredient(16157, "2 tablespoons butter", 28.4f, "Normal"),
        Ingredient(9725, "2 tablespoons extra-virgin olive oil", 27.0f, "Normal"),
        Ingredient(4409, "1/4 cup finely chopped fresh parsley leaves", 15.0f, "Normal"),
        Ingredient(9725, "1 teaspoon extra-virgin olive oil, or to taste", 4.6666665f, "Normal")
    ),
    "Shrimp Scampi with Pasta",
    6,
    20,
    20,
    -1,
    "https://images.media-allrecipes.com/userphotos/2606852.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 511.3591f, "kcal", "511", null, false),
        "fat" to NutritionValue("Fat", 19.41426f, "g", "19.4", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 135.4033f, "mg", "135", null, false),
        "sodium" to NutritionValue("Sodium", 259.9577f, "mg", "260", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 57.479f, "g", "57.5", null, false),
        "protein" to NutritionValue("Protein", 21.93898f, "g", "21.9", null, false),
        "folate" to NutritionValue("Folate", 144.1673f, "mcg", "144", null, false),
        "magnesium" to NutritionValue("Magnesium", 61.63536f, "mg", "62", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.2309691f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 7.752442f, "mg", "8", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.4167964f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 4.881809f, "mg", "5", null, false),
        "calcium" to NutritionValue("Calcium", 52.42142f, "mg", "52", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 9.845667f, "mg", "10", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 849.1954f, "IU", "849", null, false),
        "sugars" to NutritionValue("Sugars", 0.9674351f, "g", "1", null, false),
        "potassium" to NutritionValue("Potassium", 268.4891f, "mg", "268", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 6.592026f, "g", "6.6", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 174.7283f, "kcal", "175", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 3.468833f, "g", "3.5", null, false)
    )
})
val dinnerRecipes = listOf(Recipe(
    31827,
    listOf(
        Ingredient(1525, "2/3 cup packed light brown sugar", 146.66667f, "Normal"),
        Ingredient(21883, "1/4 cup cinnamon applesauce", 63.75f, "Normal"),
        Ingredient(16397, "1 1/2 teaspoons ground ginger", 2.6999998f, "Normal"),
        Ingredient(5278, "2 pounds boneless pork loin roast", 907.2f, "Normal")
    ),
    "Easy Roasted Pork",
    6,
    15,
    60,
    -1,
    "https://images.media-allrecipes.com/userphotos/288963.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 402.1272f, "kcal", "402", null, false),
        "fat" to NutritionValue("Fat", 19.04774f, "g", "19", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 95.256f, "mg", "95", null, false),
        "sodium" to NutritionValue("Sodium", 83.41853f, "mg", "83", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 26.37131f, "g", "26.4", null, false),
        "protein" to NutritionValue("Protein", 29.91726f, "g", "29.9", null, false),
        "folate" to NutritionValue("Folate", 1.931944f, "mcg", "2", null, false),
        "magnesium" to NutritionValue("Magnesium", 34.78f, "mg", "35", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.7274663f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 13.12857f, "mg", "13", null, false),
        "thiamin" to NutritionValue("Thiamin", 1.364475f, "mg", "1", null, false),
        "iron" to NutritionValue("Iron", 1.419876f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 48.02689f, "mg", "48", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.9387001f, "mg", "< 1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 11.2455f, "IU", "11", null, false),
        "sugars" to NutritionValue("Sugars", 25.47442f, "g", "25.5", null, false),
        "potassium" to NutritionValue("Potassium", 576.8267f, "mg", "577", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 6.60105f, "g", "6.6", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 171.4296f, "kcal", "171", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.2222656f, "g", "0.2", null, false)
    )
}, Recipe(
    237297,
    listOf(
        Ingredient(16421, "1 1/2 teaspoons salt", 9.0f, "Normal"),
        Ingredient(16404, "1 teaspoon paprika", 2.2808332f, "Normal"),
        Ingredient(16382, "1 teaspoon ground cardamom", 2.0f, "Normal"),
        Ingredient(18844, "1 teaspoon ground coriander", 2.0f, "Normal"),
        Ingredient(16406, "1/2 teaspoon ground black pepper", 1.05f, "Normal"),
        Ingredient(6378, "1/4 cup grapeseed oil", 54.5f, "Normal"),
        Ingredient(1536, "2 tablespoons maple syrup", 40.0f, "Normal"),
        Ingredient(2750, "1 (2 pound) salmon fillet, cut into 3-inch pieces", 908.0f, "Normal")
    ),
    "Cardamom Maple Salmon",
    6,
    15,
    10,
    -1,
    "https://images.media-allrecipes.com/userphotos/1122495.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 345.1849f, "kcal", "345", null, false),
        "fat" to NutritionValue("Fat", 23.83018f, "g", "23.8", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 74.44501f, "mg", "74", null, false),
        "sodium" to NutritionValue("Sodium", 654.3979f, "mg", "654", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 5.20954f, "g", "5.2", null, false),
        "protein" to NutritionValue("Protein", 26.27331f, "g", "26.3", null, false),
        "folate" to NutritionValue("Folate", 40.59712f, "mcg", "41", null, false),
        "magnesium" to NutritionValue("Magnesium", 38.20443f, "mg", "38", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.781315f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 14.45664f, "mg", "14", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.4054693f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 0.6907964f, "mg", "< 1", null, false),
        "calcium" to NutritionValue("Calcium", 27.69926f, "mg", "28", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 4.752529f, "mg", "5", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 260.2395f, "IU", "260", null, false),
        "sugars" to NutritionValue("Sugars", 4.008427f, "g", "4", null, false),
        "potassium" to NutritionValue("Potassium", 482.3237f, "mg", "482", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 3.845258f, "g", "3.8", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 214.4717f, "kcal", "214", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.4585469f, "g", "0.5", null, false)
    )
}, Recipe(
    88123,
    listOf(
        Ingredient(6307, "3 tablespoons olive oil", 40.5f, "Normal"),
        Ingredient(5320, "4 pork loin chops", 452.0f, "Normal"),
        Ingredient(18741, "seasoning salt to taste", 1.0f, "HideAmounts"),
        Ingredient(16406, "black pepper to taste", 1.0f, "HideAmounts"),
        Ingredient(16396, "garlic powder to taste", 1.0f, "HideAmounts"),
        Ingredient(16410, "1/2 teaspoon poultry seasoning", 0.6166667f, "Normal"),
        Ingredient(7428, "3 tablespoons Worcestershire sauce", 51.0f, "Normal"),
        Ingredient(
            24031,
            "1 (8 ounce) container frozen apple cider concentrate, undiluted",
            227.0f,
            "Normal"
        ),
        Ingredient(15720, "1/4 cup dry sherry", 59.8021f, "Normal")
    ),
    "Apple Cider Sauce and Pork Loin Chops",
    4,
    10,
    45,
    -1,
    "https://images.media-allrecipes.com/userphotos/1101450.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 324.8438f, "kcal", "325", null, false),
        "fat" to NutritionValue("Fat", 16.60688f, "g", "16.6", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 36.9375f, "mg", "37", null, false),
        "sodium" to NutritionValue("Sodium", 307.2948f, "mg", "307", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 28.5749f, "g", "28.6", null, false),
        "protein" to NutritionValue("Protein", 14.08118f, "g", "14.1", null, false),
        "folate" to NutritionValue("Folate", 3.8156f, "mcg", "4", null, false),
        "magnesium" to NutritionValue("Magnesium", 21.75733f, "mg", "22", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.239615f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 5.330687f, "mg", "5", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.279947f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.938023f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 40.34628f, "mg", "40", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 3.207503f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 33.62467f, "IU", "34", null, false),
        "sugars" to NutritionValue("Sugars", 23.4567f, "g", "23.5", null, false),
        "potassium" to NutritionValue("Potassium", 573.9911f, "mg", "574", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 3.760262f, "g", "3.8", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 149.462f, "kcal", "149", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.3417208f, "g", "0.3", null, false)
    )
}, Recipe(
    9023,
    listOf(
        Ingredient(1636, "1 tablespoon cornstarch", 8.0f, "Normal"),
        Ingredient(2496, "1 tablespoon cold water", 14.785f, "Normal"),
        Ingredient(1526, "1/2 cup white sugar", 100.0f, "Normal"),
        Ingredient(2882, "1/2 cup soy sauce", 128.0f, "Normal"),
        Ingredient(16422, "1/4 cup cider vinegar", 59.75f, "Normal"),
        Ingredient(4342, "1 clove garlic, minced", 3.0f, "Normal"),
        Ingredient(16397, "1/2 teaspoon ground ginger", 0.9f, "Normal"),
        Ingredient(16406, "1/4 teaspoon ground black pepper", 0.525f, "Normal"),
        Ingredient(6527, "12 skinless chicken thighs", 828.0f, "Normal")
    ),
    "Baked Teriyaki Chicken",
    6,
    30,
    60,
    -1,
    "https://images.media-allrecipes.com/userphotos/4530047.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 271.8699f, "kcal", "272", null, false),
        "fat" to NutritionValue("Fat", 9.779211f, "g", "9.8", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 85.18333f, "mg", "85", null, false),
        "sodium" to NutritionValue("Sodium", 1282.33f, "mg", "1282", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 19.92454f, "g", "19.9", null, false),
        "protein" to NutritionValue("Protein", 24.6578f, "g", "24.7", null, false),
        "folate" to NutritionValue("Folate", 10.24225f, "mcg", "10", null, false),
        "magnesium" to NutritionValue("Magnesium", 31.82664f, "mg", "32", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.3531392f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 11.16695f, "mg", "11", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.07498438f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.665249f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 17.23905f, "mg", "17", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.184875f, "mg", "< 1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 58.81046f, "IU", "59", null, false),
        "sugars" to NutritionValue("Sugars", 17.06481f, "g", "17.1", null, false),
        "potassium" to NutritionValue("Potassium", 272.4887f, "mg", "272", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 2.722299f, "g", "2.7", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 88.0129f, "kcal", "88", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.2351042f, "g", "0.2", null, false)
    )
}, Recipe(
    213742,
    listOf(
        Ingredient(22104, "1 pound extra lean ground beef", 454.0f, "Normal"),
        Ingredient(18752, "1/2 teaspoon sea salt", 2.75f, "Normal"),
        Ingredient(4397, "1 small onion, diced", 70.0f, "Normal"),
        Ingredient(18740, "1/2 teaspoon garlic salt", 2.75f, "Normal"),
        Ingredient(20245, "1 1/2 teaspoons Italian seasoning", 2.25f, "Normal"),
        Ingredient(16403, "3/4 teaspoon dried oregano", 1.125f, "Normal"),
        Ingredient(20244, "3/4 teaspoon crushed red pepper flakes", 2.25f, "Normal"),
        Ingredient(5592, "1 dash hot pepper sauce (such as Frank's RedHotÂ®), or to taste", 1.0f, "Normal"),
        Ingredient(7428, "1 1/2 tablespoons Worcestershire sauce", 25.5f, "Normal"),
        Ingredient(16284, "1/3 cup skim milk", 81.666664f, "Normal"),
        Ingredient(16238, "1/4 cup grated Parmesan cheese", 20.0f, "Normal"),
        Ingredient(2363, "1/2 cup seasoned bread crumbs", 60.0f, "Normal")
    ),
    "Meatball Nirvana",
    4,
    20,
    20,
    -1,
    "https://images.media-allrecipes.com/userphotos/397070.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 343.1422f, "kcal", "343", null, false),
        "fat" to NutritionValue("Fat", 16.81017f, "g", "16.8", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 94.80084f, "mg", "95", null, false),
        "sodium" to NutritionValue("Sodium", 939.8853f, "mg", "940", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 15.30573f, "g", "15.3", null, false),
        "protein" to NutritionValue("Protein", 31.03836f, "g", "31", null, false),
        "folate" to NutritionValue("Folate", 36.17286f, "mcg", "36", null, false),
        "magnesium" to NutritionValue("Magnesium", 43.14684f, "mg", "43", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.3923373f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 7.429677f, "mg", "7", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1055241f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 6.709788f, "mg", "7", null, false),
        "calcium" to NutritionValue("Calcium", 141.8622f, "mg", "142", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 3.567499f, "mg", "4", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 390.7916f, "IU", "391", null, false),
        "sugars" to NutritionValue("Sugars", 3.395901f, "g", "3.4", null, false),
        "potassium" to NutritionValue("Potassium", 512.9084f, "mg", "513", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 6.768217f, "g", "6.8", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 151.2915f, "kcal", "151", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.549341f, "g", "1.5", null, false)
    )
}, Recipe(
    8701,
    listOf(
        Ingredient(6494, "4 skinless, boneless chicken breasts", 472.0f, "Normal"),
        Ingredient(16421, "salt and pepper to taste", 0.0f, "HideAmounts"),
        Ingredient(4378, "3/4 pound fresh mushrooms, sliced", 340.5f, "Normal"),
        Ingredient(1684, "2 tablespoons all-purpose flour", 15.625f, "Normal"),
        Ingredient(6307, "2 tablespoons olive oil", 27.0f, "Normal"),
        Ingredient(4342, "6 cloves garlic", 18.0f, "Normal"),
        Ingredient(18930, "1/4 cup balsamic vinegar", 60.0f, "Normal"),
        Ingredient(16133, "3/4 cup chicken broth", 148.5f, "Normal"),
        Ingredient(16380, "1 bay leaf", 0.15f, "Normal"),
        Ingredient(16417, "1/4 teaspoon dried thyme", 0.35833332f, "Normal"),
        Ingredient(16157, "1 tablespoon butter", 14.2f, "Normal")
    ),
    "Chicken Breasts with Balsamic Vinegar and Garlic",
    4,
    5,
    25,
    -1,
    "https://images.media-allrecipes.com/userphotos/335668.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 267.5019f, "kcal", "268", null, false),
        "fat" to NutritionValue("Fat", 11.57635f, "g", "11.6", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 77.00999f, "mg", "77", null, false),
        "sodium" to NutritionValue("Sodium", 286.2803f, "mg", "286", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 9.853183f, "g", "9.9", null, false),
        "protein" to NutritionValue("Protein", 30.85347f, "g", "30.9", null, false),
        "folate" to NutritionValue("Folate", 26.0429f, "mcg", "26", null, false),
        "magnesium" to NutritionValue("Magnesium", 42.99871f, "mg", "43", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.7960755f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 22.49647f, "mg", "22", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.199517f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.816835f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 31.78006f, "mg", "32", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 4.752354f, "mg", "5", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 119.623f, "IU", "120", null, false),
        "sugars" to NutritionValue("Sugars", 3.860771f, "g", "3.9", null, false),
        "potassium" to NutritionValue("Potassium", 607.6693f, "mg", "608", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 3.194968f, "g", "3.2", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 104.1872f, "kcal", "104", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.094227f, "g", "1.1", null, false)
    )
}, Recipe(
    220125,
    listOf(
        Ingredient(3898, "1 (5 pound) bone-in beef pot roast", 2268.0f, "Normal"),
        Ingredient(16421, "salt and pepper to taste", 0.4f, "HideAmounts"),
        Ingredient(1684, "1 tablespoon all-purpose flour, or as needed", 7.8125f, "Normal"),
        Ingredient(6379, "2 tablespoons vegetable oil", 27.5f, "Normal"),
        Ingredient(4378, "8 ounces sliced mushrooms", 224.0f, "Normal"),
        Ingredient(4397, "1 medium onion, chopped", 110.0f, "Normal"),
        Ingredient(4342, "2 cloves garlic, minced", 6.0f, "Normal"),
        Ingredient(16157, "1 tablespoon butter", 14.2f, "Normal"),
        Ingredient(1684, "1 1/2 tablespoons all-purpose flour", 11.71875f, "Normal"),
        Ingredient(3640, "1 tablespoon tomato paste", 16.23009f, "Normal"),
        Ingredient(16133, "2 1/2 cups chicken broth", 495.0f, "Normal"),
        Ingredient(4279, "3 medium carrots, cut into chunks", 183.0f, "Normal"),
        Ingredient(4292, "2 stalks celery, cut into chunks", 80.0f, "Normal"),
        Ingredient(16429, "1 sprig fresh rosemary", 0.7f, "Normal"),
        Ingredient(16423, "2 sprigs fresh thyme", 0.8f, "Normal")
    ),
    "Slow Cooker Beef Pot Roast",
    8,
    20,
    390,
    -1,
    "https://images.media-allrecipes.com/userphotos/3536308.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 776.8989f, "kcal", "777", null, false),
        "fat" to NutritionValue("Fat", 57.30892f, "g", "57.3", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 198.1588f, "mg", "198", null, false),
        "sodium" to NutritionValue("Sodium", 538.837f, "mg", "539", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 7.541828f, "g", "7.5", null, false),
        "protein" to NutritionValue("Protein", 54.52597f, "g", "54.5", null, false),
        "folate" to NutritionValue("Folate", 39.8111f, "mcg", "40", null, false),
        "magnesium" to NutritionValue("Magnesium", 66.29231f, "mg", "66", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 1.177302f, "mg", "1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 20.77374f, "mg", "21", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.3935916f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 6.449627f, "mg", "6", null, false),
        "calcium" to NutritionValue("Calcium", 38.97069f, "mg", "39", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 4.122599f, "mg", "4", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 3949.345f, "IU", "3949", null, false),
        "sugars" to NutritionValue("Sugars", 2.862493f, "g", "2.9", null, false),
        "potassium" to NutritionValue("Potassium", 1109.31f, "mg", "1109", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 22.48918f, "g", "22.5", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 515.7803f, "kcal", "516", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.483977f, "g", "1.5", null, false)
    )
}, Recipe(
    223499,
    listOf(
        Ingredient(6305, "1 teaspoon vegetable oil", 4.5416665f, "Normal"),
        Ingredient(5937, "7 slices turkey bacon, or more to taste", 196.0f, "Normal"),
        Ingredient(22113, "1 pound extra lean ground turkey", 454.0f, "Normal"),
        Ingredient(16215, "1 cup shredded Cheddar cheese", 113.0f, "Normal"),
        Ingredient(16317, "1 egg", 50.0f, "Normal"),
        Ingredient(4397, "1/2 small onion, diced", 35.0f, "Normal"),
        Ingredient(2073, "1 slice French bread, crumbled", 25.0f, "Normal"),
        Ingredient(7428, "2 tablespoons Worcestershire sauce, or more to taste", 34.0f, "Normal"),
        Ingredient(16396, "2 teaspoons garlic powder", 5.5533333f, "Normal"),
        Ingredient(16406, "1/4 teaspoon ground black pepper", 0.525f, "Normal"),
        Ingredient(0, "", 0.0f, "BlankLine"),
        Ingredient(3686, "1/4 cup ketchup", 60.0f, "Normal"),
        Ingredient(16420, "2 tablespoons prepared yellow mustard", 30.837004f, "Normal"),
        Ingredient(1525, "1 1/2 tablespoons brown sugar", 20.352423f, "Normal")
    ),
    "Turkey Cheeseburger Meatloaf",
    6,
    20,
    55,
    -1,
    "https://images.media-allrecipes.com/userphotos/879634.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 253.2874f, "kcal", "253", null, false),
        "fat" to NutritionValue("Fat", 10.81287f, "g", "10.8", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 107.2883f, "mg", "107", null, false),
        "sodium" to NutritionValue("Sodium", 548.8973f, "mg", "549", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 11.32636f, "g", "11.3", null, false),
        "protein" to NutritionValue("Protein", 27.08399f, "g", "27.1", null, false),
        "folate" to NutritionValue("Folate", 23.36261f, "mcg", "23", null, false),
        "magnesium" to NutritionValue("Magnesium", 37.40355f, "mg", "37", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.5229241f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 9.967422f, "mg", "10", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.08159264f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.988141f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 169.9958f, "mg", "170", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 2.948734f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 331.0974f, "IU", "331", null, false),
        "sugars" to NutritionValue("Sugars", 7.098123f, "g", "7.1", null, false),
        "potassium" to NutritionValue("Potassium", 393.7926f, "mg", "394", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 5.112383f, "g", "5.1", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 97.31587f, "kcal", "97", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.5135877f, "g", "0.5", null, false)
    )
}, Recipe(
    222002,
    listOf(
        Ingredient(1650, "1 cup uncooked long grain white rice", 185.0f, "Normal"),
        Ingredient(2496, "2 cups water", 474.0f, "Normal"),
        Ingredient(0, "Sauce:", 0.0f, "Heading"),
        Ingredient(4397, "1 onion, diced", 110.0f, "Normal"),
        Ingredient(6307, "1 tablespoon olive oil", 13.5f, "Normal"),
        Ingredient(5803, "2 cups marinara sauce", 500.0f, "Normal"),
        Ingredient(5460, "1 cup beef broth", 242.0f, "Normal"),
        Ingredient(18930, "1 tablespoon balsamic vinegar", 15.0f, "Normal"),
        Ingredient(20244, "1/4 teaspoon crushed red pepper flakes", 0.75f, "Normal"),
        Ingredient(0, "Peppers:", 0.0f, "Heading"),
        Ingredient(4147, "1 pound lean ground beef", 454.0f, "Normal"),
        Ingredient(21886, "1/4 pound hot Italian pork sausage, casing removed", 113.5f, "Normal"),
        Ingredient(10498, "1 (10 ounce) can diced tomatoes", 283.5f, "Normal"),
        Ingredient(20699, "1/4 cup chopped fresh Italian parsley", 15.0f, "Normal"),
        Ingredient(4342, "4 cloves garlic, minced", 12.0f, "Normal"),
        Ingredient(16421, "2 teaspoons salt", 12.0f, "Normal"),
        Ingredient(16406, "1 teaspoon freshly ground black pepper", 2.1f, "Normal"),
        Ingredient(16407, "1 pinch ground cayenne pepper", 0.2f, "Normal"),
        Ingredient(4432, "4 large green bell peppers, halved lengthwise and seeded", 656.0f, "Normal"),
        Ingredient(
            16238,
            "1 cup finely grated Parmigiano-Reggiano cheese, plus more for topping",
            80.0f,
            "Normal"
        )
    ),
    "Chef John's Stuffed Peppers",
    8,
    30,
    80,
    -1,
    "https://images.media-allrecipes.com/userphotos/1415039.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 376.8688f, "kcal", "377", null, false),
        "fat" to NutritionValue("Fat", 16.9299f, "g", "16.9", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 51.885f, "mg", "52", null, false),
        "sodium" to NutritionValue("Sodium", 1273.967f, "mg", "1274", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 35.05497f, "g", "35.1", null, false),
        "protein" to NutritionValue("Protein", 20.12954f, "g", "20.1", null, false),
        "folate" to NutritionValue("Folate", 81.16338f, "mcg", "81", null, false),
        "magnesium" to NutritionValue("Magnesium", 45.401f, "mg", "45", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.5244444f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 9.661268f, "mg", "10", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.3180481f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 3.977124f, "mg", "4", null, false),
        "calcium" to NutritionValue("Calcium", 171.7859f, "mg", "172", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 74.14426f, "mg", "74", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 1139.029f, "IU", "1139", null, false),
        "sugars" to NutritionValue("Sugars", 9.39345f, "g", "9.4", null, false),
        "potassium" to NutritionValue("Potassium", 636.2454f, "mg", "636", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 6.474974f, "g", "6.5", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 152.3691f, "kcal", "152", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 4.041484f, "g", "4", null, false)
    )
}, Recipe(
    16707,
    listOf(
        Ingredient(6494, "6 skinless, boneless chicken breast halves", 708.0f, "Normal"),
        Ingredient(1684, "1/4 cup all-purpose flour", 31.25f, "Normal"),
        Ingredient(16421, "1/2 teaspoon salt", 3.0f, "Normal"),
        Ingredient(16406, "1 pinch ground black pepper", 1.0f, "Normal"),
        Ingredient(16157, "3 tablespoons butter", 42.6f, "Normal"),
        Ingredient(4575, "1 (14.5 ounce) can stewed tomatoes, with liquid", 406.0f, "Normal"),
        Ingredient(2496, "1/2 cup water", 118.5f, "Normal"),
        Ingredient(1525, "2 tablespoons brown sugar", 27.136564f, "Normal"),
        Ingredient(7842, "2 tablespoons distilled white vinegar", 29.603525f, "Normal"),
        Ingredient(7428, "2 tablespoons Worcestershire sauce", 34.0f, "Normal"),
        Ingredient(16421, "1 teaspoon salt", 6.0f, "Normal"),
        Ingredient(16385, "2 teaspoons chili powder", 5.2949777f, "Normal"),
        Ingredient(16400, "1 teaspoon mustard powder", 3.7333333f, "Normal"),
        Ingredient(16383, "1/2 teaspoon celery seed", 1.08333f, "Normal"),
        Ingredient(4342, "1 clove garlic, minced", 3.0f, "Normal"),
        Ingredient(5593, "1/8 teaspoon hot pepper sauce", 0.5875f, "Normal")
    ),
    "Chicken Breasts Pierre",
    6,
    30,
    40,
    -1,
    "https://images.media-allrecipes.com/userphotos/1009113.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 246.5426f, "kcal", "247", null, false),
        "fat" to NutritionValue("Fat", 7.78278f, "g", "7.8", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 83.70499f, "mg", "84", null, false),
        "sodium" to NutritionValue("Sodium", 916.017f, "mg", "916", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 14.75495f, "g", "14.8", null, false),
        "protein" to NutritionValue("Protein", 28.81308f, "g", "28.8", null, false),
        "folate" to NutritionValue("Folate", 19.75223f, "mcg", "20", null, false),
        "magnesium" to NutritionValue("Magnesium", 48.41304f, "mg", "48", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.7084249f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 19.74958f, "mg", "20", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1636144f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 2.656707f, "mg", "3", null, false),
        "calcium" to NutritionValue("Calcium", 59.77225f, "mg", "60", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 8.308962f, "mg", "8", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 587.3613f, "IU", "587", null, false),
        "sugars" to NutritionValue("Sugars", 7.469642f, "g", "7.5", null, false),
        "potassium" to NutritionValue("Potassium", 527.8217f, "mg", "528", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 4.103475f, "g", "4.1", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 70.04501f, "kcal", "70", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 1.287132f, "g", "1.3", null, false)
    )
})
val snacks = listOf(Recipe(
    7519,
    listOf(
        Ingredient(16318, "10 egg whites", 334.0f, "Normal"),
        Ingredient(2360, "1 teaspoon cream of tartar", 3.0f, "Normal"),
        Ingredient(16421, "1/2 teaspoon salt", 3.0f, "Normal"),
        Ingredient(1526, "1 1/4 cups white sugar, divided", 250.0f, "Normal"),
        Ingredient(1687, "3/4 cup sifted cake flour", 107.37375f, "Normal"),
        Ingredient(16319, "6 egg yolks", 99.600006f, "Normal"),
        Ingredient(20221, "1/2 teaspoon orange extract", 2.4f, "Normal"),
        Ingredient(1687, "1/2 cup sifted cake flour", 68.5f, "Normal"),
        Ingredient(16424, "1 teaspoon vanilla extract", 4.3333335f, "Normal")
    ),
    "Daffodil Cake",
    12,
    15,
    50,
    -1,
    "https://images.media-allrecipes.com/userphotos/2293554.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 175.5103f, "kcal", "176", null, false),
        "fat" to NutritionValue("Fat", 2.32908f, "g", "2.3", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 102.422f, "mg", "102", null, false),
        "sodium" to NutritionValue("Sodium", 147.546f, "mg", "148", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 32.96594f, "g", "33", null, false),
        "protein" to NutritionValue("Protein", 5.552234f, "g", "5.6", null, false),
        "folate" to NutritionValue("Folate", 40.49176f, "mcg", "40", null, false),
        "magnesium" to NutritionValue("Magnesium", 5.872483f, "mg", "6", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.03537209f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 2.098768f, "mg", "2", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1465525f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.334328f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 15.03525f, "mg", "15", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.0f, "mg", "0", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 119.686f, "IU", "120", null, false),
        "sugars" to NutritionValue("Sugars", 21.14979f, "g", "21.1", null, false),
        "potassium" to NutritionValue("Potassium", 112.0254f, "mg", "112", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 0.8113824f, "g", "0.8", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 20.96172f, "kcal", "21", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.2496545f, "g", "0.2", null, false)
    )
}, Recipe(
    12101,
    listOf(
        Ingredient(1525, "1 cup packed light brown sugar", 220.0f, "Normal"),
        Ingredient(1636, "4 tablespoons cornstarch", 32.0f, "Normal"),
        Ingredient(16421, "1/2 teaspoon salt", 3.0f, "Normal"),
        Ingredient(16278, "2 cups milk", 488.0f, "Normal"),
        Ingredient(16319, "2 egg yolks, beaten", 33.2f, "Normal"),
        Ingredient(16157, "1 tablespoon butter", 14.2f, "Normal"),
        Ingredient(16424, "1 teaspoon vanilla extract", 4.3333335f, "Normal"),
        Ingredient(2327, "1 (9 inch) pie crust, baked", 126.0f, "Normal")
    ),
    "Grandma's Butterscotch Pie",
    8,
    25,
    35,
    -1,
    "https://images.media-allrecipes.com/userphotos/5124825.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 258.6372f, "kcal", "259", null, false),
        "fat" to NutritionValue("Fat", 8.911138f, "g", "8.9", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 59.90725f, "mg", "60", null, false),
        "sodium" to NutritionValue("Sodium", 292.5797f, "mg", "293", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 41.51092f, "g", "41.5", null, false),
        "protein" to NutritionValue("Protein", 3.423003f, "g", "3.4", null, false),
        "folate" to NutritionValue("Folate", 18.09975f, "mcg", "18", null, false),
        "magnesium" to NutritionValue("Magnesium", 12.45175f, "mg", "12", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.06035659f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 1.145275f, "mg", "1", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.07729334f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 0.7038375f, "mg", "< 1", null, false),
        "calcium" to NutritionValue("Calcium", 103.5116f, "mg", "104", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.122f, "mg", "< 1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 219.4902f, "IU", "219", null, false),
        "sugars" to NutritionValue("Sugars", 30.29435f, "g", "30.3", null, false),
        "potassium" to NutritionValue("Potassium", 151.3012f, "mg", "151", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 3.742155f, "g", "3.7", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 80.20024f, "kcal", "80", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.1935f, "g", "0.2", null, false)
    )
}, Recipe(
    7570,
    listOf(
        Ingredient(16157, "1 cup butter, softened", 227.0f, "Normal"),
        Ingredient(1526, "1 cup white sugar", 200.0f, "Normal"),
        Ingredient(16317, "3 eggs", 150.0f, "Normal"),
        Ingredient(16424, "1/4 teaspoon vanilla extract", 1.0833334f, "Normal"),
        Ingredient(1684, "2 cups all-purpose flour", 250.0f, "Normal"),
        Ingredient(2356, "1 teaspoon baking powder", 4.6f, "Normal"),
        Ingredient(16421, "1/8 teaspoon salt", 0.75f, "Normal"),
        Ingredient(20185, "2 drops red food coloring", 2.0f, "Normal"),
        Ingredient(1593, "1 cup apricot preserves", 320.0f, "Normal"),
        Ingredient(0, "", 0.0f, "BlankLine"),
        Ingredient(3767, "2 cups ground almonds", 340.0f, "Normal"),
        Ingredient(1527, "3 cups confectioners' sugar", 360.0f, "Normal"),
        Ingredient(16317, "1 egg, room temperature", 50.0f, "Normal"),
        Ingredient(5107, "1 1/2 teaspoons lemon juice", 8.061674f, "Normal"),
        Ingredient(19113, "1/4 teaspoon almond extract", 1.1510416f, "Normal")
    ),
    "Battenburg Cake",
    12,
    30,
    30,
    -1,
    "https://images.media-allrecipes.com/userphotos/2692736.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 645.6867f, "kcal", "646", null, false),
        "fat" to NutritionValue("Fat", 31.63769f, "g", "31.6", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 102.6708f, "mg", "103", null, false),
        "sodium" to NutritionValue("Sodium", 208.8387f, "mg", "209", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 85.52284f, "g", "85.5", null, false),
        "protein" to NutritionValue("Protein", 10.62248f, "g", "10.6", null, false),
        "folate" to NutritionValue("Folate", 55.0965f, "mcg", "55", null, false),
        "magnesium" to NutritionValue("Magnesium", 86.10193f, "mg", "86", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.07638359f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 4.215057f, "mg", "4", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.2433157f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 2.674876f, "mg", "3", null, false),
        "calcium" to NutritionValue("Calcium", 115.1666f, "mg", "115", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 2.655698f, "mg", "3", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 611.5286f, "IU", "612", null, false),
        "sugars" to NutritionValue("Sugars", 59.18148f, "g", "59.2", null, false),
        "potassium" to NutritionValue("Potassium", 277.9483f, "mg", "278", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 11.37408f, "g", "11.4", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 284.7392f, "kcal", "285", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 3.989287f, "g", "4", null, false)
    )
}, Recipe(
    261757,
    listOf(
        Ingredient(
            5135,
            "2 large organic oranges, scrubbed and coarsely chopped (with the skin)",
            368.0f,
            "Normal"
        ),
        Ingredient(16317, "5 eggs, separated", 250.0f, "Normal"),
        Ingredient(1526, "1 cup white sugar, divided", 200.0f, "Normal"),
        Ingredient(22884, "3/4 cup ground almonds", 93.72f, "Normal"),
        Ingredient(1670, "3/4 cup semolina flour", 125.25f, "Normal"),
        Ingredient(16424, "1/2 teaspoon vanilla extract", 2.1666667f, "Normal"),
        Ingredient(0, "1/2 teaspoon fiori di Sicilia (optional)", 0.0f, "WriteIn"),
        Ingredient(
            20667,
            "3 tablespoons brandy-based orange liqueur (such as Grand MarnierÂ®)",
            42.0f,
            "Normal"
        ),
        Ingredient(1527, "1/2 teaspoon confectioners' sugar (optional)", 1.25f, "OptionalIngredient")
    ),
    "Orange Cake with Semolina and Almonds",
    10,
    30,
    80,
    -1,
    "https://images.media-allrecipes.com/userphotos/4674336.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 245.9433f, "kcal", "246", null, false),
        "fat" to NutritionValue("Fat", 7.293528f, "g", "7.3", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 93.0f, "mg", "93", null, false),
        "sodium" to NutritionValue("Sodium", 35.419f, "mg", "35", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 37.62277f, "g", "37.6", null, false),
        "protein" to NutritionValue("Protein", 7.06132f, "g", "7.1", null, false),
        "folate" to NutritionValue("Folate", 45.71075f, "mcg", "46", null, false),
        "magnesium" to NutritionValue("Magnesium", 12.65575f, "mg", "13", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.07078709f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 1.947516f, "mg", "2", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1491176f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.045405f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 30.34533f, "mg", "30", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 19.5776f, "mg", "20", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 204.55f, "IU", "205", null, false),
        "sugars" to NutritionValue("Sugars", 26.01441f, "g", "26", null, false),
        "potassium" to NutritionValue("Potassium", 124.7577f, "mg", "125", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 1.164624f, "g", "1.2", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 65.64175f, "kcal", "66", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 2.361675f, "g", "2.4", null, false)
    )
}, Recipe(
    262623,
    listOf(
        Ingredient(1684, "2 cups all-purpose flour", 250.0f, "Normal"),
        Ingredient(22884, "2 cups finely ground almonds", 249.92f, "Normal"),
        Ingredient(1526, "1 1/4 cups white sugar", 250.0f, "Normal"),
        Ingredient(2356, "1 teaspoon baking powder", 4.6f, "Normal"),
        Ingredient(16386, "1/2 teaspoon ground cinnamon", 1.15f, "Normal"),
        Ingredient(16387, "1/8 teaspoon ground cloves", 0.2625f, "Normal"),
        Ingredient(16339, "1 1/8 cups unsalted butter", 255.375f, "Normal"),
        Ingredient(16319, "2 egg yolks", 33.2f, "Normal"),
        Ingredient(18419, "6 tablespoons red currant jam", 120.0f, "Normal"),
        Ingredient(16319, "2 egg yolks, lightly beaten", 33.2f, "Normal")
    ),
    "Austrian Linzer Torte ",
    12,
    25,
    45,
    -1,
    "https://images.media-allrecipes.com/userphotos/5106661.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 473.0961f, "kcal", "473", null, false),
        "fat" to NutritionValue("Fat", 29.20618f, "g", "29.2", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 114.036f, "mg", "114", null, false),
        "sodium" to NutritionValue("Sodium", 46.10968f, "mg", "46", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 48.0353f, "g", "48", null, false),
        "protein" to NutritionValue("Protein", 7.615692f, "g", "7.6", null, false),
        "folate" to NutritionValue("Folate", 46.8682f, "mcg", "47", null, false),
        "magnesium" to NutritionValue("Magnesium", 5.504375f, "mg", "6", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.02945225f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 1.887499f, "mg", "2", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1741114f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.176182f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 39.20506f, "mg", "39", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.02131667f, "mg", "< 1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 612.0078f, "IU", "612", null, false),
        "sugars" to NutritionValue("Sugars", 27.65052f, "g", "27.7", null, false),
        "potassium" to NutritionValue("Potassium", 34.57794f, "mg", "35", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 12.30072f, "g", "12.3", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 262.8556f, "kcal", "263", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 2.821635f, "g", "2.8", null, false)
    )
}, Recipe(
    261483,
    listOf(
        Ingredient(10536, "cooking spray", 0.266f, "HideAmounts"),
        Ingredient(
            15899,
            "1 (15.25 ounce) package spiced cake mix (such as Betty CrockerÂ®)",
            427.0f,
            "Normal"
        ),
        Ingredient(2496, "1 cup water", 237.0f, "Normal"),
        Ingredient(16317, "3 eggs", 150.0f, "Normal"),
        Ingredient(6305, "1/3 cup vegetable oil", 72.66667f, "Normal"),
        Ingredient(3819, "1 cup chopped walnuts", 117.0f, "Normal"),
        Ingredient(1338, "1 cup semisweet chocolate chips", 168.0f, "Normal"),
        Ingredient(1460, "1 (16 ounce) can prepared chocolate frosting", 454.0f, "Normal"),
        Ingredient(1527, "1 tablespoon confectioners' sugar (optional)", 7.4008813f, "OptionalIngredient")
    ),
    "Can't Wait Microwave Lava Cake",
    4,
    10,
    7,
    -1,
    "https://images.media-allrecipes.com/userphotos/4510959.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 1526.246f, "kcal", "1526", null, false),
        "fat" to NutritionValue("Fat", 86.95619f, "g", "87", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 139.5f, "mg", "140", null, false),
        "sodium" to NutritionValue("Sodium", 994.1735f, "mg", "994", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 183.3707f, "g", "183.4", null, false),
        "protein" to NutritionValue("Protein", 18.69652f, "g", "18.7", null, false),
        "folate" to NutritionValue("Folate", 51.75f, "mcg", "52", null, false),
        "magnesium" to NutritionValue("Magnesium", 123.4425f, "mg", "123", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.2310725f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 2.930861f, "mg", "3", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1608475f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 6.319953f, "mg", "6", null, false),
        "calcium" to NutritionValue("Calcium", 130.074f, "mg", "130", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.38025f, "mg", "< 1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 931.9f, "IU", "932", null, false),
        "sugars" to NutritionValue("Sugars", 139.2807f, "g", "139.3", null, false),
        "potassium" to NutritionValue("Potassium", 688.002f, "mg", "688", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 24.54623f, "g", "24.5", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 782.6057f, "kcal", "783", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 7.68075f, "g", "7.7", null, false)
    )
}, Recipe(
    261413,
    listOf(
        Ingredient(2377, "1 (14.1 ounce) package pie crust pastry", 399.735f, "Normal"),
        Ingredient(18427, "3/4 (10 ounce) jar seedless raspberry jam", 210.0f, "Normal"),
        Ingredient(16339, "3/4 cup unsalted butter", 170.25f, "Normal"),
        Ingredient(1526, "3/4 cup white sugar", 150.0f, "Normal"),
        Ingredient(1526, "2 tablespoons white sugar", 25.0f, "Normal"),
        Ingredient(16317, "4 eggs", 200.0f, "Normal"),
        Ingredient(5107, "1 1/2 tablespoons lemon juice", 22.572687f, "Normal"),
        Ingredient(19113, "2 teaspoons almond extract", 9.208333f, "Normal"),
        Ingredient(5110, "1 teaspoon lemon zest", 2.0f, "Normal"),
        Ingredient(22884, "2 cups ground almonds", 249.92f, "Normal"),
        Ingredient(10866, "1/2 cup sliced almonds", 47.0f, "Normal"),
        Ingredient(1527, "confectioners' sugar", 16.0f, "HideAmounts")
    ),
    "Bakewell Slice",
    12,
    30,
    50,
    -1,
    "https://images.media-allrecipes.com/userphotos/4579313.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 534.4186f, "kcal", "534", null, false),
        "fat" to NutritionValue("Fat", 35.70728f, "g", "35.7", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 92.50313f, "mg", "93", null, false),
        "sodium" to NutritionValue("Sodium", 185.5105f, "mg", "186", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 46.84017f, "g", "46.8", null, false),
        "protein" to NutritionValue("Protein", 9.344233f, "g", "9.3", null, false),
        "folate" to NutritionValue("Folate", 33.79373f, "mcg", "34", null, false),
        "magnesium" to NutritionValue("Magnesium", 18.20813f, "mg", "18", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.03736894f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 2.105036f, "mg", "2", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1276302f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.167559f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 26.40385f, "mg", "26", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 1.080286f, "mg", "1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 436.1718f, "IU", "436", null, false),
        "sugars" to NutritionValue("Sugars", 27.42625f, "g", "27.4", null, false),
        "potassium" to NutritionValue("Potassium", 72.31865f, "mg", "72", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 11.32822f, "g", "11.3", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 321.3655f, "kcal", "321", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 3.757273f, "g", "3.8", null, false)
    )
}, Recipe(
    262588,
    listOf(
        Ingredient(0, "Caramel:", 0.0f, "Heading"),
        Ingredient(1526, "1 cup white sugar", 200.0f, "Normal"),
        Ingredient(2496, "1/2 cup water", 118.5f, "Normal"),
        Ingredient(2496, "1 tablespoon water", 14.785f, "Normal"),
        Ingredient(0, "Pudding:", 0.0f, "Heading"),
        Ingredient(2496, "2 cups water", 474.0f, "Normal"),
        Ingredient(1526, "2 cups white sugar", 400.0f, "Normal"),
        Ingredient(5375, "4 slices smoked bacon, finely chopped", 112.0f, "Normal"),
        Ingredient(20303, "2 cinnamon sticks", 4.0f, "Normal"),
        Ingredient(5110, "peels from 2 lemons, white pith removed", 6.0f, "HideAmounts"),
        Ingredient(16319, "15 egg yolks", 249.0f, "Normal"),
        Ingredient(20492, "1/2 cup port wine", 117.0f, "Normal")
    ),
    "Abade Prisco's Pudding",
    8,
    30,
    75,
    -1,
    "https://images.media-allrecipes.com/userphotos/5124955.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 426.9875f, "kcal", "427", null, false),
        "fat" to NutritionValue("Fat", 10.14913f, "g", "10.1", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 389.0325f, "mg", "389", null, false),
        "sodium" to NutritionValue("Sodium", 121.9936f, "mg", "122", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 77.08749f, "g", "77.1", null, false),
        "protein" to NutritionValue("Protein", 6.644663f, "g", "6.6", null, false),
        "folate" to NutritionValue("Folate", 45.80625f, "mcg", "46", null, false),
        "magnesium" to NutritionValue("Magnesium", 5.821606f, "mg", "6", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.13462f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 1.699644f, "mg", "2", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.0845025f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.023725f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 50.85857f, "mg", "51", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 0.9865f, "mg", "< 1", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 452.3375f, "IU", "452", null, false),
        "sugars" to NutritionValue("Sugars", 75.26447f, "g", "75.3", null, false),
        "potassium" to NutritionValue("Potassium", 79.44411f, "mg", "79", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 3.593021f, "g", "3.6", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 91.34213f, "kcal", "91", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 0.345f, "g", "0.3", null, false)
    )
}, Recipe(
    261295,
    listOf(
        Ingredient(4978, "12 apples, cored and cut into 8 wedges", 1656.0f, "Normal"),
        Ingredient(1525, "3/4 cup brown sugar", 108.75f, "Normal"),
        Ingredient(16386, "2 teaspoons ground cinnamon, divided", 4.6f, "Normal"),
        Ingredient(1684, "1 cup all-purpose flour, divided", 125.0f, "Normal"),
        Ingredient(16157, "1/2 cup cold butter", 113.5f, "Normal"),
        Ingredient(19148, "1 1/2 cups old-fashioned rolled oats", 120.0f, "Normal"),
        Ingredient(3819, "1 cup chopped walnuts", 120.0f, "Normal"),
        Ingredient(1536, "1/3 cup maple syrup", 105.0f, "Normal"),
        Ingredient(16411, "1 teaspoon pumpkin pie spice", 1.7f, "Normal"),
        Ingredient(16424, "1 teaspoon vanilla extract", 4.3333335f, "Normal"),
        Ingredient(16421, "1/2 teaspoon salt", 3.0f, "Normal")
    ),
    "Sheet Pan Apple Crisp",
    12,
    20,
    45,
    -1,
    "https://images.media-allrecipes.com/userphotos/4576318.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 340.1393f, "kcal", "340", null, false),
        "fat" to NutritionValue("Fat", 15.31966f, "g", "15.3", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 20.33542f, "mg", "20", null, false),
        "sodium" to NutritionValue("Sodium", 156.6328f, "mg", "157", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 50.34597f, "g", "50.3", null, false),
        "protein" to NutritionValue("Protein", 4.322784f, "g", "4.3", null, false),
        "folate" to NutritionValue("Folate", 33.47213f, "mcg", "33", null, false),
        "magnesium" to NutritionValue("Magnesium", 27.68996f, "mg", "28", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.1203039f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 1.417866f, "mg", "1", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.1415742f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.622243f, "mg", "2", null, false),
        "calcium" to NutritionValue("Calcium", 40.20376f, "mg", "40", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 6.525717f, "mg", "7", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 314.3843f, "IU", "314", null, false),
        "sugars" to NutritionValue("Sugars", 28.94843f, "g", "28.9", null, false),
        "potassium" to NutritionValue("Potassium", 238.2248f, "mg", "238", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 5.664701f, "g", "5.7", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 137.8769f, "kcal", "138", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 5.487767f, "g", "5.5", null, false)
    )
}, Recipe(
    16875,
    listOf(
        Ingredient(2216, "2 cups vanilla wafer crumbs", 360.0f, "Normal"),
        Ingredient(5015, "3 bananas, sliced into 1/4 inch slices", 354.0f, "Normal"),
        Ingredient(1526, "1 1/2 cups white sugar", 300.0f, "Normal"),
        Ingredient(1684, "1/4 cup all-purpose flour", 31.25f, "Normal"),
        Ingredient(16278, "2 cups milk", 488.0f, "Normal"),
        Ingredient(16319, "3 egg yolks", 49.800003f, "Normal"),
        Ingredient(16157, "2 teaspoons butter", 10.0f, "Normal"),
        Ingredient(16424, "2 teaspoons vanilla extract", 8.666667f, "Normal"),
        Ingredient(16318, "3 egg whites", 100.200005f, "Normal"),
        Ingredient(1526, "1/4 cup white sugar", 50.0f, "Normal")
    ),
    "Homemade Banana Pudding Pie",
    8,
    30,
    30,
    -1,
    "https://images.media-allrecipes.com/userphotos/3138228.jpg"
).apply {
    nutrition = mutableMapOf(
        "calories" to NutritionValue("Calories", 504.0915f, "kcal", "504", null, false),
        "fat" to NutritionValue("Fat", 12.78265f, "g", "12.8", null, false),
        "cholesterol" to NutritionValue("Cholesterol", 84.384f, "mg", "84", null, false),
        "sodium" to NutritionValue("Sodium", 194.3076f, "mg", "194", null, false),
        "carbohydrates" to NutritionValue("Carbohydrates", 92.13131f, "g", "92.1", null, false),
        "protein" to NutritionValue("Protein", 7.197626f, "g", "7.2", null, false),
        "folate" to NutritionValue("Folate", 48.02544f, "mcg", "48", null, false),
        "magnesium" to NutritionValue("Magnesium", 26.76088f, "mg", "27", null, false),
        "vitaminB6" to NutritionValue("Vitamin B6", 0.2208292f, "mg", "< 1", null, false),
        "niacin" to NutritionValue("Niacin Equivalents", 3.360986f, "mg", "3", null, false),
        "thiamin" to NutritionValue("Thiamin", 0.2483322f, "mg", "< 1", null, false),
        "iron" to NutritionValue("Iron", 1.494987f, "mg", "1", null, false),
        "calcium" to NutritionValue("Calcium", 95.1821f, "mg", "95", null, false),
        "vitaminC" to NutritionValue("Vitamin C", 3.97175f, "mg", "4", null, false),
        "vitaminA" to NutritionValue("Vitamin A - IU", 265.062f, "IU", "265", null, false),
        "sugars" to NutritionValue("Sugars", 52.24933f, "g", "52.2", null, false),
        "potassium" to NutritionValue("Potassium", 332.224f, "mg", "332", null, false),
        "saturatedFat" to NutritionValue("Saturated Fat", 4.280343f, "g", "4.3", null, false),
        "caloriesFromFat" to NutritionValue("Calories from Fat", 115.0438f, "kcal", "115", null, false),
        "fiber" to NutritionValue("Dietary Fiber", 2.155969f, "g", "2.2", null, false)
    )
})

private val categoryMapping = mapOf(
    CategoryName.Breakfast to breakfastRecipes,
    CategoryName.Lunch to lunchRecipes,
    CategoryName.Dinner to dinnerRecipes,
    CategoryName.Snacks to snacks
)

fun getRandomRecipes(count: Int = 10, categories: List<CategoryName> = emptyList()) : List<Recipe> {
    val recipeCategories = if (categories.isEmpty()) categoryMapping.keys.toList() else categories
    val categoryCount = categoryMapping
        .map { (category, _) -> category to count / recipeCategories.size }
        .associate { it }
    val missingCount = count - categoryCount.asIterable().sumBy { it.value }

    return categoryCount
        .asIterable()
        .mapIndexed { index, (category, count) -> category to if (index < missingCount) count + 1 else count }
        .flatMap { (category, count) -> categoryMapping.getValue(category).shuffled().take(count) }
        .shuffled()
}
