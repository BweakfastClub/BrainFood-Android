package club.bweakfast.foodora.user

import club.bweakfast.foodora.recipe.Recipe

/**
 * Created by silve on 3/2/2018.
 */

data class User(val email: String) {
    var name = ""
    var password = ""
    var likedRecipes: List<Recipe>? = emptyList()
    val mealPlan: Map<String, List<Recipe>>? = emptyMap()
}