package club.bweakfast.foodora.plan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import club.bweakfast.foodora.R
import club.bweakfast.foodora.browse.category.CategoryName
import club.bweakfast.foodora.custom.NutritionInfoLayout
import club.bweakfast.foodora.custom.NutritionView
import club.bweakfast.foodora.getRandomRecipes
import club.bweakfast.foodora.recipe.RecipesAdapter
import kotlinx.android.synthetic.main.fragment_meal_plan.*
import kotlin.math.roundToInt

/**
 * A simple [Fragment] subclass.
 * Use the [MealPlanFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MealPlanFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal_plan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val breakfast = getRandomRecipes(2, listOf(CategoryName.Breakfast))
        breakfastRecipes.recyclerView.adapter = RecipesAdapter(breakfast, true)
        breakfastRecipes.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val lunch = getRandomRecipes(1, listOf(CategoryName.Lunch))
        lunchRecipes.recyclerView.adapter = RecipesAdapter(lunch, true)
        lunchRecipes.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val recipes = breakfast + lunch
        val nutritionKeys = linkedMapOf(
            "calories" to NutritionView(NutritionInfoLayout::nutritionInfo1, "Calories", false),
            "protein" to NutritionView(NutritionInfoLayout::nutritionInfo2, "Protein"),
            "fat" to NutritionView(NutritionInfoLayout::nutritionInfo3, "Total Fat"),
            "carbohydrates" to NutritionView(NutritionInfoLayout::nutritionInfo4, "Total Carbs")
        )
        val nutritionInfo = recipes
            .asSequence()
            .map { recipe -> recipe.nutrition.filterKeys { key -> nutritionKeys.containsKey(key) } }
            .fold(mapOf<String, Pair<Int, String?>>()) { total, nutrition ->
                nutrition
                    .entries
                    .associate { (key, value) ->
                    val (currentValue, unit) = total[key] ?: (0 to value.unit)
                    key to ((value.amount.toInt() + currentValue) to unit)
                }
            }

        nutritionKeys.forEach {(key, nutrition) ->
            val (nutritionSetter, title, useUnit) = nutrition
            nutritionInfoLayout.apply {
                var (amount, unit) = nutritionInfo[key]!!
                unit = if (useUnit) unit ?: "" else ""
                val amountStr = "$amount$unit"

                nutritionSetter.set(this, title to amountStr)
            }
        }
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
