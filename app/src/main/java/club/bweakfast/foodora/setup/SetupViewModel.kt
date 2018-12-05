package club.bweakfast.foodora.setup

import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.recipe.RecipeService
import club.bweakfast.foodora.user.UserService
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetupViewModel @Inject constructor(
    private val storageService: StorageService,
    private val userService: UserService,
    private val recipeService: RecipeService
) {
    var isSetupComplete: Boolean
        get() = storageService.isSetupComplete
        set(value) {
            storageService.isSetupComplete = value
        }

    val isStep1Valid: Boolean
        get() = validateStep1()

    var isStep2Valid: Boolean = false
        private set

    var selectedRecipeIDs = listOf<Int>()
        set(value) {
            field = value
            isStep2Valid = value.size >= 3
        }

    var name: String?
        get() = storageService.name
        set(value) {
            storageService.name = value
        }

    val isVegan: Boolean
        get() = storageService.isVegan

    val isVegetarian: Boolean
        get() = storageService.isVegetarian

    val hasPeanutAllergy: Boolean
        get() = storageService.hasPeanutAllergy

    fun addAllergies(): Completable {
        val allergies = mutableListOf<String>()

        if (isVegan) allergies.add("Vegan")
        if (isVegetarian) allergies.add("Vegetarian")
        if (hasPeanutAllergy) allergies.add("Peanuts")

        return userService.addAllergies(allergies)
    }

    fun addLikedRecipes(): Completable = Completable.merge(selectedRecipeIDs.map { recipeService.likeRecipe(it) })

    fun getRandomRecipes(numRecipes: Int = 8) = recipeService.getRandomRecipes(numRecipes)

    private fun validateStep1(): Boolean {
        return !name.isNullOrBlank()
    }
}