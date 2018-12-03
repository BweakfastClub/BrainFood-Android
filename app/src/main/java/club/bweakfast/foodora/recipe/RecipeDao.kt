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
    fun getLikedRecipes(): Single<List<Recipe>>
    fun isLikedRecipe(recipeID: Int): Single<Boolean>
    fun addLikedRecipe(recipeID: Int): Completable
    fun removeLikedRecipe(recipeID: Int): Completable
    fun getRecipesInMealPlan(): Single<Map<String, List<Recipe>>>
    fun getCategoryNamesForRecipeInMealPlan(recipeID: Int): Single<List<String>>
    fun isRecipeInMealPlan(recipeID: Int): Single<Boolean>
    fun addRecipeToMealPlan(recipeID: Int, categoryNames: List<String>): Completable
    fun removeRecipeFromMealPlan(recipeID: Int, categoryName: String): Completable
}