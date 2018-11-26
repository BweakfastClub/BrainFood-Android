package club.bweakfast.foodora.recipe

import io.reactivex.Completable
import io.reactivex.Single

interface RecipeDao {
    fun getRecipes(recipeIDs: List<Int>? = null): Single<List<Recipe>>
    fun getRecipesList(recipeIDs: List<Int>? = null): List<Recipe>
    fun getRecipe(recipeID: Int): Single<Recipe>
    fun getRecipeVal(recipeID: Int): Recipe
    fun addRecipe(recipe: Recipe): Completable
    fun removeRecipe(recipe: Recipe): Completable
}