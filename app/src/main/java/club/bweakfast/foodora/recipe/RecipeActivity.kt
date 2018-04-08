package club.bweakfast.foodora.recipe

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.Intents
import club.bweakfast.foodora.R
import club.bweakfast.foodora.TwoLineText
import club.bweakfast.foodora.onError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.content_recipe.*
import kotlinx.android.synthetic.main.layout_two_line.view.*
import javax.inject.Inject
import kotlin.math.roundToInt

class RecipeActivity : AppCompatActivity() {
    private var loading = false
        set(value) {
            if (value) {
                fabProgressCircle.show()
            } else {
                fabProgressCircle.hide()
            }
        }

    @Inject
    lateinit var recipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        FoodoraApp.daggerComponent.inject(this)

        val recipe = intent.getParcelableExtra<Recipe>(Intents.INTENT_RECIPE_ACTIVITY)
        fab.setOnClickListener { view ->
            loading = true
            with(recipe) {
                val completable = if (isFavourite) {
                    recipeViewModel.likeRecipe(id)
                } else {
                    recipeViewModel.unlikeRecipe(id)
                }
                completable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        setFABIcon(isFavourite)
                        val snackbarText = if (!isFavourite) {
                            "Added to favourites"
                        } else {
                            "Removed from favourites"
                        }
                        Snackbar.make(view, snackbarText, Snackbar.LENGTH_LONG).show()
                        isFavourite = !isFavourite
                        loading = false
                    }, {
                        onError(it)
                        loading = false
                    })
            }
        }

        init(recipe)
    }

    private fun init(recipe: Recipe) {
        val nutritionKeys = listOf(
            NutritionView("calories", R.id.calories, false),
            NutritionView("protein", R.id.protein),
            NutritionView("fat", R.id.fat),
            NutritionView("carbohydrates", R.id.carbs)
        )
        nutritionKeys.forEach { (key, layoutID, useUnit) ->
            val twoLineText = findViewById<TwoLineText>(layoutID)
            twoLineText.apply {
                val nutritionValue = recipe.nutrition[key]!!
                val unit = if (useUnit) nutritionValue.unit else ""
                val amount = "${nutritionValue.amount.roundToInt()}$unit"

                text1.text = amount
                text2.text = key.toUpperCase()
            }
        }

        image.setImageURI(recipe.imageURL)
        supportActionBar?.title = recipe.title
        ingredientList.adapter = IngredientAdapter(recipe.ingredients.filter { it.name.isNotBlank() })
        ingredientList.layoutManager = LinearLayoutManager(this)
        ingredientList.isFocusable = false
        nestedScrollView.requestFocus()
    }

    private fun setFABIcon(isFavourite: Boolean) {
        if (!isFavourite) {
            fab.setImageResource(R.drawable.ic_heart)
        } else {
            fab.setImageResource(R.drawable.ic_heart_outline)
        }
    }

    private inner class NutritionView(val key: String, val layoutID: Int, val useUnit: Boolean = true) {
        operator fun component1() = key

        operator fun component2() = layoutID

        operator fun component3() = useUnit
    }
}
