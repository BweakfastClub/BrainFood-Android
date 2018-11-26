package club.bweakfast.foodora.recipe

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.core.view.get
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.Intents
import club.bweakfast.foodora.R
import club.bweakfast.foodora.category.CategoryAdapter
import club.bweakfast.foodora.custom.NutritionInfoLayout
import club.bweakfast.foodora.custom.NutritionView
import club.bweakfast.foodora.recipe.ingredient.IngredientAdapter
import club.bweakfast.foodora.user.UserViewModel
import club.bweakfast.foodora.util.buildBottomSheet
import club.bweakfast.foodora.util.log
import club.bweakfast.foodora.util.onError
import club.bweakfast.foodora.util.showDarkStatusIcons
import club.bweakfast.foodora.util.showView
import club.bweakfast.foodora.util.toDP
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.content_recipe.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import javax.inject.Inject
import kotlin.math.roundToInt

class RecipeActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    private val subscriptions = CompositeDisposable()
    private lateinit var recipe: Recipe

    @Inject
    lateinit var recipeViewModel: RecipeViewModel
    @Inject
    lateinit var userViewModel: UserViewModel

    private var isLiked: Boolean = false
        set(value) {
            field = value
            invalidateOptionsMenu()
        }

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
        showView(fab, userViewModel.isLoggedIn)

        fab.setOnClickListener(::clickOnMealPlanBtn)

        subscriptions.addAll(
            recipeViewModel.isRecipeInMealPlan(recipe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { isInMealPlan, err ->
                    if (err != null) {
                        onError(err, this)
                    } else {
                        fab.text = if (isInMealPlan) getString(R.string.action_remove_meal_plan) else getString(R.string.action_add_meal_plan)
                    }
                },
            recipeViewModel.isLikedRecipe(recipe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { isLikedRecipe, err ->
                    if (err != null) {
                        onError(err, this)
                    } else {
                        isLiked = isLikedRecipe
                    }
                }
        )
    }

    private fun init(recipe: Recipe) {
        val nutritionKeys = linkedMapOf(
            "calories" to NutritionView(NutritionInfoLayout::nutritionInfo1, "Calories", false),
            "protein" to NutritionView(NutritionInfoLayout::nutritionInfo2, "Protein"),
            "fat" to NutritionView(NutritionInfoLayout::nutritionInfo3, "Total Fat"),
            "carbohydrates" to NutritionView(NutritionInfoLayout::nutritionInfo4, "Total Carbs")
        )
        val nutritionLayout = findViewById<NutritionInfoLayout>(R.id.nutritionInfoLayout)
        nutritionKeys.forEach { (key, nutrition) ->
            val (nutritionInfo, title, useUnit) = nutrition
            nutritionLayout.apply {
                val nutritionValue = recipe.nutrition[key]!!
                val unit = if (useUnit) nutritionValue.unit else ""
                val amount = "${nutritionValue.amount.roundToInt()}$unit"

                nutritionInfo.set(this, title to amount)
            }
        }

        image.setImageURI(recipe.imageURL)
        supportActionBar?.title = recipe.title
        ingredientList.adapter = IngredientAdapter(recipe.ingredients.filter { it.name.isNotBlank() })
        ingredientList.layoutManager = LinearLayoutManager(this)
        ingredientList.isFocusable = false
        nestedScrollView.requestFocus()
        showDarkStatusIcons(window.decorView, false)
    }

    @SuppressLint("RxLeakedSubscription")
    private fun clickOnMealPlanBtn(view: View) {
        val fab = view as Button
        val isAdding = fab.text == getString(R.string.action_add_meal_plan)

        buildBottomSheet(title = getString(R.string.title_add_meal_plan_question)) {
            val categories = mutableListOf<String>()

            val customView = LayoutInflater.from(this@RecipeActivity).inflate(R.layout.fragment_list, null)
            setCustomView(customView)
            customView.rv.adapter = CategoryAdapter { categoryName, add ->
                val listAction = if (add) categories::add else categories::remove
                listAction(categoryName)
            }
            customView.rv.layoutManager = LinearLayoutManager(customView.context)

            setNegativeText(R.string.action_cancel)
            setPositiveText(R.string.action_ok)
            setPositiveTextColor(R.color.black)
            onPositive {
                updateMealPlanBtn(isAdding)

                val completable = if (isAdding) {
                    recipeViewModel.addRecipeToMealPlan(recipe, categories)
                } else {
                    Completable.merge(categories.map { recipeViewModel.removeRecipeFromMealPlan(recipe, it) })
                }
                subscriptions.addAll(
                    completable
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({
                            val snackbarText = if (isAdding) "Added recipe to meal plan" else "Removed recipe from meal plan"
                            Snackbar.make(rootLayout, snackbarText, Snackbar.LENGTH_LONG).show()
                        }, {
                            updateMealPlanBtn(!isAdding)
                            onError(it, this@RecipeActivity)
                        })
                )
            }
        }
    }

    private fun updateMealPlanBtn(isAdding: Boolean) {
        fab.text = if (isAdding) getString(R.string.action_remove_meal_plan) else getString(R.string.action_add_meal_plan)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_recipe, menu)
        updateLikeIcon(isLiked, menu[0])
        return userViewModel.isLoggedIn
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_like -> {
                clickOnLikeItem(recipe, item)
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> false
        }
    }

    private fun clickOnLikeItem(recipe: Recipe, menuItem: MenuItem) {
        with(recipe) {
            val completable = if (isFavourite) {
                recipeViewModel.unlikeRecipe(this)
            } else {
                recipeViewModel.likeRecipe(this)
            }
            isFavourite = !isFavourite
            updateLikeIcon(isFavourite, menuItem)
            subscriptions.add(
                completable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        val snackbarText = if (isFavourite) "Added to favourites" else "Removed from favourites"
                        Snackbar.make(rootLayout, snackbarText, Snackbar.LENGTH_LONG).show()
                    }, {
                        updateLikeIcon(!isFavourite, menuItem)
                        onError(it, this@RecipeActivity)
                        isFavourite = !isFavourite
                    })
            )
        }
    }

    private fun updateLikeIcon(isFavourite: Boolean, menuItem: MenuItem) {
        val iconResource = if (isFavourite) R.drawable.ic_heart else R.drawable.ic_heart_outline
        menuItem.icon = ContextCompat.getDrawable(this, iconResource)
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
}
