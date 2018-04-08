package club.bweakfast.foodora.recipe

import club.bweakfast.foodora.network.mapResponse
import javax.inject.Inject

class RecipeViewModel @Inject constructor(private val recipeService: RecipeService) {
    fun likeRecipe(recipeID: String) = recipeService.likeRecipe(recipeID).mapResponse()

    fun unlikeRecipe(recipeID: String) = recipeService.unlikeRecipe(recipeID).mapResponse()
}