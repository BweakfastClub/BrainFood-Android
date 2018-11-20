package club.bweakfast.foodora.recipe.ingredient

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import club.bweakfast.foodora.breakfastRecipes
import club.bweakfast.foodora.di.component.DaggerFoodoraTestComponent
import club.bweakfast.foodora.di.module.FoodoraTestModule
import club.bweakfast.foodora.recipe.RecipeDao
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class IngredientDaoTest {
    private val recipe = breakfastRecipes.first()
    private lateinit var countDownLatch: CountDownLatch

    @Inject
    lateinit var recipeDao: RecipeDao
    @Inject
    lateinit var ingredientDao: IngredientDao

    @Before
    fun setup() {
        countDownLatch = CountDownLatch(1)

        DaggerFoodoraTestComponent
            .builder()
            .foodoraTestModule(FoodoraTestModule(InstrumentationRegistry.getContext()))
            .build()
            .inject(this)
    }

    @Test
    fun testGetIngredients() {
        with(recipe) {
            var error: Throwable? = null
            var ingredients = emptyList<Ingredient>()

            recipeDao.addRecipe(this)
                .andThen(ingredientDao.saveIngredients(ingredients, id))
                .andThen(ingredientDao.getIngredients(id))
                .subscribeOn(Schedulers.io())
                .doOnError {
                    error = it
                    countDownLatch.countDown()
                }
                .subscribe { ingredientList ->
                    ingredients = ingredientList
                    countDownLatch.countDown()
                }

            countDownLatch.await()
            Assert.assertNull(error)
            ingredients.forEach { ingredient -> Assert.assertTrue(ingredients.any { it == ingredient }) }
            countDownLatch = CountDownLatch(1)
        }
    }
}