package club.bweakfast.foodora.browse

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import club.bweakfast.foodora.breakfastRecipes
import club.bweakfast.foodora.browse.category.CategoryName
import club.bweakfast.foodora.dinnerRecipes
import club.bweakfast.foodora.lunchRecipes
import club.bweakfast.foodora.recipe.RecipesListFragment
import club.bweakfast.foodora.snacks

/**
 * A simple [Fragment] subclass.
 */
class BrowseCategoryFragment : RecipesListFragment() {
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            category = arguments!!.getString(ARG_CATEGORY)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipes = when (CategoryName.valueOf(category)) {
            CategoryName.Breakfast -> breakfastRecipes
            CategoryName.Lunch -> lunchRecipes
            CategoryName.Dinner -> dinnerRecipes
            CategoryName.Snacks -> snacks
        }
    }

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: CategoryName): BrowseCategoryFragment {
            val fragment = BrowseCategoryFragment()
            val args = Bundle()
            args.putString(ARG_CATEGORY, category.name)
            fragment.arguments = args
            return fragment
        }
    }
}
