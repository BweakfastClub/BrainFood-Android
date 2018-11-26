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
import club.bweakfast.foodora.custom.SectionTitleAdapter
import club.bweakfast.foodora.custom.SectionTitleLayout
import club.bweakfast.foodora.recipe.RecipeViewModel
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.util.onError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_meal_plan.*
import kotlinx.android.synthetic.main.item_section_title.*
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

                    if (mealPlan.isEmpty()) {

                    } else {
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
