package club.bweakfast.foodora.recipe

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.Intents
import club.bweakfast.foodora.R
import club.bweakfast.foodora.custom.NutritionInfoLayout
import club.bweakfast.foodora.recipe.ingredient.IngredientAdapter
import club.bweakfast.foodora.util.log
import club.bweakfast.foodora.util.onError
import club.bweakfast.foodora.util.showDarkStatusIcons
import club.bweakfast.foodora.util.toDP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.content_recipe.*
import javax.inject.Inject
import kotlin.math.roundToInt
import kotlin.reflect.KMutableProperty1

class RecipeActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    private val subscriptions = CompositeDisposable()
    private lateinit var recipe: Recipe

    @Inject
    lateinit var recipeViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.black))
        toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white))
        ViewCompat.setElevation(fab, 6f.toDP(this))

        FoodoraApp.daggerComponent.inject(this)

        recipe = intent.getParcelableExtra(Intents.INTENT_RECIPE_ACTIVITY)

        init(recipe)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_recipe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_like -> {
                clickOnLikeItem(recipe, item)
                true
            }
            else -> false
        }
    }

    override fun onResume() {
        super.onResume()
        appBar.addOnOffsetChangedListener(this)
    }

    override fun onPause() {
        super.onPause()
        appBar.removeOnOffsetChangedListener(this)
    }

    override fun onDestroy() {
        subscriptions.clear()
        super.onDestroy()
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        log("Vertical offset: $verticalOffset")

        val isCollapsed = verticalOffset < -119
        showDarkStatusIcons(window.decorView, isCollapsed)

        val iconColor = ContextCompat.getColor(
            this,
            if (isCollapsed) R.color.materialGray else R.color.white
        )
        toolbar.navigationIcon!!.setColorFilter(iconColor, PorterDuff.Mode.SRC_ATOP)
        toolbar.menu.findItem(R.id.menu_like)?.icon?.setColorFilter(iconColor, PorterDuff.Mode.SRC_ATOP)
    }

    private fun clickOnLikeItem(recipe: Recipe, menuItem: MenuItem) {
        with(recipe) {
            val completable = if (isFavourite) {
                recipeViewModel.unlikeRecipe(this)
            } else {
                recipeViewModel.likeRecipe(this)
            }
            setLikeIcon(isFavourite, menuItem)
            subscriptions.add(
                completable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        val snackbarText = if (isFavourite) "Removed from favourites" else "Added to favourites"
                        Snackbar.make(rootLayout, snackbarText, Snackbar.LENGTH_LONG).show()
                        isFavourite = !isFavourite
                    }, {
                        onError(it, this@RecipeActivity)
                    })
            )
        }
    }

    private fun init(recipe: Recipe) {
        val nutritionKeys = listOf(
            NutritionView("calories", NutritionInfoLayout::nutritionInfo1, useUnit = false),
            NutritionView("protein", NutritionInfoLayout::nutritionInfo2),
            NutritionView("fat", NutritionInfoLayout::nutritionInfo3, "Total Fat"),
            NutritionView("carbohydrates", NutritionInfoLayout::nutritionInfo4, "Total Carbs")
        )
        val nutritionLayout = findViewById<NutritionInfoLayout>(R.id.nutritionInfoLayout)
        nutritionKeys.forEach { (key, nutritionInfo, title, useUnit) ->
            nutritionLayout.apply {
                val nutritionValue = recipe.nutrition[key]!!
                val unit = if (useUnit) nutritionValue.unit else ""
                val amount = "${nutritionValue.amount.roundToInt()}$unit"

                nutritionInfo.set(nutritionLayout, amount to title)
            }
        }

        image.setImageURI(recipe.imageURL)
        supportActionBar?.title = recipe.title
        ingredientList.adapter = IngredientAdapter(recipe.ingredients.filter { it.name.isNotBlank() })
        ingredientList.layoutManager = LinearLayoutManager(this)
        ingredientList.isFocusable = false
        nestedScrollView.requestFocus()
    }

    private fun setLikeIcon(isFavourite: Boolean, menuItem: MenuItem) {
        val iconResource = if (isFavourite) R.drawable.ic_heart_outline else R.drawable.ic_heart
        menuItem.icon = ContextCompat.getDrawable(this, iconResource)
    }

    private inner class NutritionView(
        val key: String,
        val layoutID: KMutableProperty1<NutritionInfoLayout, Pair<String, String>?>,
        val title: String = key.capitalize(),
        val useUnit: Boolean = true
    ) {
        operator fun component1() = key

        operator fun component2() = layoutID

        operator fun component3() = title

        operator fun component4() = useUnit
    }
}
