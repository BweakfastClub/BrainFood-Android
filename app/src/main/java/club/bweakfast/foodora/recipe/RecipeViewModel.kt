package club.bweakfast.foodora.recipe

import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RecipeViewModel @Inject constructor(private val recipeService: RecipeService, private val recipeDao: RecipeDao) {
    fun likeRecipe(recipe: Recipe): Completable {
        return Completable.merge(
            listOf(
                recipeDao.addRecipe(recipe),
                recipeDao.addLikedRecipe(recipe.id),
                recipeService.likeRecipe(recipe.id)
            )
        )
    }

    fun unlikeRecipe(recipe: Recipe): Completable {
        return Completable.merge(
            listOf(
                recipeDao.removeLikedRecipe(recipe.id),
                recipeService.unlikeRecipe(recipe.id)
            )
        )
    }

    fun isLikedRecipe(recipe: Recipe) = recipeDao.isLikedRecipe(recipe.id)

    fun getFavouriteRecipes(): Single<List<Recipe>> = recipeDao.getLikedRecipes()

    fun getMealPlan() = recipeDao.getRecipesInMealPlan()

    fun getCategoryNamesForRecipeInMealPlan(recipe: Recipe) = recipeDao.getCategoryNamesForRecipeInMealPlan(recipe.id)

    fun isRecipeInMealPlan(recipe: Recipe) = recipeDao.isRecipeInMealPlan(recipe.id)

    fun addRecipeToMealPlan(recipe: Recipe, categoryNames: List<String>): Completable {
        return Completable.merge(
            listOf(
                recipeDao.addRecipe(recipe),
                recipeDao.addRecipeToMealPlan(recipe.id, categoryNames),
                recipeService.addRecipeToMealPlan(recipe.id, categoryNames)
            )
        )
    }

    fun removeRecipeFromMealPlan(recipe: Recipe, categoryName: String): Completable {
        return Completable.merge(
            listOf(
                recipeDao.removeRecipeFromMealPlan(recipe.id, categoryName),
                recipeService.removeRecipeFromMealPlan(recipe.id, categoryName)
            )
        )
    }

    fun getTopRecipes() = recipeService.getTopRecipes()

    fun getRecommendedRecipes(recipe: Recipe? = null) = recipeService.getRecommendedRecipes(recipe?.id)
}