package club.bweakfast.foodora.user

import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.recipe.RecipeDao
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class UserViewModel @Inject constructor(
    private val authService: AuthenticationService,
    private val userService: UserService,
    private val storageService: StorageService,
    private val recipeDao: RecipeDao
) {
    val isLoggedIn = authService.isLoggedIn

    fun login(email: String, password: String): Completable {
        return authService.login(email, password)
            .flatMapCompletable { (token) ->
                storageService.token = token
                Completable.complete()
            }
    }

    fun register(name: String, email: String, password: String): Completable {
        return authService.register(name, email, password)
            .flatMapCompletable { (token) ->
                storageService.token = token
                Completable.complete()
            }
    }

    fun getUserInfo(): Single<User> {
        return userService.getUserInfo().flatMap { user ->
            val dbOperations = mutableListOf<Completable>()

            user.likedRecipes?.let { dbOperations.addAll(it.map { recipeDao.addRecipe(it).andThen(recipeDao.addLikedRecipe(it.id)) }) }
            user.mealPlan?.let {
                dbOperations.addAll(it.flatMap { (categoryName, recipes) ->
                    recipes.map {
                        recipeDao.addRecipe(it).andThen(recipeDao.addRecipeToMealPlan(it.id, listOf(categoryName)))
                    }
                })
            }
            Completable.merge(dbOperations)
                .andThen(Single.just(user))
        }
    }

    fun updateUserInfo(userInfoJSON: Map<String, String>) = userService.updateUserInfo(userInfoJSON)
}