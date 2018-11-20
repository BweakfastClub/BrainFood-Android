package club.bweakfast.foodora.recipe.nutrition

import io.reactivex.Completable
import io.reactivex.Single

interface NutritionDao {
    fun getNutrition(recipeID: Int): Single<List<NutritionValue>>

    fun saveNutrition(nutrition: List<NutritionValue>, recipeID: Int): Completable

    fun deleteNutrition(recipeID: Int): Completable
}