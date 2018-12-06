package club.bweakfast.foodora.plan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R
import club.bweakfast.foodora.custom.NutritionInfoLayout
import club.bweakfast.foodora.custom.NutritionView
import club.bweakfast.foodora.custom.RecipeListView
import club.bweakfast.foodora.recipe.RecipeViewModel
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.util.onError
import club.bweakfast.foodora.util.showView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_meal_plan.*
import kotlinx.android.synthetic.main.layout_empty_view.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [MealPlanFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MealPlanFragment : Fragment() {
    @Inject
    lateinit var recipeViewModel: RecipeViewModel

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FoodoraApp.daggerComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal_plan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.text = getString(R.string.msg_empty_meal_plan)

        showView(emptyView, false)
        showView(nutritionScrollingLayout, false)
    }

    override fun onResume() {
        super.onResume()

        if (nutritionLayout.childCount > 1) nutritionLayout.removeViewsInLayout(1, nutritionLayout.childCount - 1)

        disposable = recipeViewModel.getMealPlan()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { mealPlan, err ->
                if (err != null) {
                    onError(err, requireContext())
                } else {
                    mealPlan.entries.forEach { (nutritionKey, recipes)->
                        RecipeListView(requireContext()).apply {
                            title = nutritionKey
                            recyclerView.apply {
                                adapter = RecipesAdapter(recipes, true)
                                layoutManager = LinearLayoutManager(context)
                                isNestedScrollingEnabled = false
                            }
                            nutritionLayout.addView(this)
                        }
                    }

                    showView(emptyView, mealPlan.isEmpty())
                    showView(nutritionScrollingLayout, mealPlan.isNotEmpty())

                    if (!mealPlan.isEmpty()) {
                        val nutritionKeys = linkedMapOf(
                            "calories" to NutritionView(NutritionInfoLayout::nutritionInfo1, "Calories", false),
                            "protein" to NutritionView(NutritionInfoLayout::nutritionInfo2, "Protein"),
                            "fat" to NutritionView(NutritionInfoLayout::nutritionInfo3, "Total Fat"),
                            "carbohydrates" to NutritionView(NutritionInfoLayout::nutritionInfo4, "Total Carbs")
                        )
                        val nutritionInfo = mealPlan.values
                            .asSequence()
                            .flatten()
                            .map { recipe -> recipe.nutrition.filterKeys { key -> nutritionKeys.containsKey(key) } }
                            .fold(mapOf<String, Pair<Int, String?>>()) { total, nutrition ->
                                nutrition
                                    .entries
                                    .associate { (key, value) ->
                                        val (currentValue, unit) = total[key] ?: (0 to value.unit)
                                        key to ((value.amount.toInt() + currentValue) to unit)
                                    }
                            }

                        nutritionKeys.forEach { (key, nutrition) ->
                            val (nutritionSetter, title, useUnit) = nutrition
                            nutritionInfoLayout.apply {
                                var (amount, unit) = nutritionInfo[key]!!
                                unit = if (useUnit) unit ?: "" else ""
                                val amountStr = "$amount$unit"

                                nutritionSetter.set(this, title to amountStr)
                            }
                        }
                    }
                }
            }
    }

    override fun onDestroyView() {
        disposable.dispose()
        super.onDestroyView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MealPlanFragment.
         */
        @JvmStatic
        fun newInstance() = MealPlanFragment()
    }
}
