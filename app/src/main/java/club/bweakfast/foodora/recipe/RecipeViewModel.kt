package club.bweakfast.foodora.recipe

import club.bweakfast.foodora.favourite.FavouriteDao
import club.bweakfast.foodora.favourite.FavouriteType
import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RecipeViewModel @Inject constructor(
    private val recipeService: RecipeService,
    private val recipeDao: RecipeDao,
    private val favouriteDao: FavouriteDao
) {
    fun likeRecipe(recipe: Recipe): Completable {
        return Completable.merge(
            listOf(
                recipeDao.addRecipe(recipe),
                favouriteDao.addFavourite(recipe),
                recipeService.likeRecipe(recipe.id)
            )
        )
    }

    fun unlikeRecipe(recipe: Recipe): Completable {
        return Completable.merge(
            listOf(
                recipeDao.removeRecipe(recipe),
                favouriteDao.removeFavourite(recipe),
                recipeService.unlikeRecipe(recipe.id)
            )
        )
    }

    fun addRecipeToMealPlan(recipe: Recipe): Completable {
        return recipeService.addRecipeToMealPlan(recipe.id)
    }

    fun removeRecipeFromMealPlan(recipe: Recipe): Completable {
        return recipeService.removeRecipeFromMealPlan(recipe.id)
    }

    fun getFavouriteRecipes(): Single<List<Recipe>> = favouriteDao.getFavourites(FavouriteType.RECIPE).flatMap(recipeDao::getRecipes)
}