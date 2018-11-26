package club.bweakfast.foodora.recipe.ingredient

import io.reactivex.Completable
import io.reactivex.Single

interface IngredientDao {
    fun saveIngredients(ingredients: List<Ingredient>, recipeID: Int): Completable
    fun getIngredients(recipeID: Int): Single<List<Ingredient>>
    fun getIngredientsList(recipeID: Int): List<Ingredient>
    fun deleteIngredients(recipeID: Int): Completable
}