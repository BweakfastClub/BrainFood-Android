package club.bweakfast.foodora.search

/**
 * Created by silve on 3/5/2018.
 */

data class Recipe(
    val ingredients: List<Ingredient>,
    val title: String,
    val nutrition: Map<String, String>,
    val servings: Int,
    val imageURL: String
)