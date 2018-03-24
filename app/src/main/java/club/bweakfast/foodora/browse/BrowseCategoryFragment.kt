package club.bweakfast.foodora.browse

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.R
import club.bweakfast.foodora.breakfastRecipes
import club.bweakfast.foodora.browse.category.CategoryName
import club.bweakfast.foodora.dinnerRecipes
import club.bweakfast.foodora.lunchRecipes
import club.bweakfast.foodora.snacks
import kotlinx.android.synthetic.main.fragment_browse_category.*

/**
 * A simple [Fragment] subclass.
 */
class BrowseCategoryFragment : Fragment() {
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            category = arguments!!.getString(ARG_CATEGORY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipesGrid.adapter = RecipesAdapter(
            when (CategoryName.valueOf(category)) {
                CategoryName.Breakfast -> breakfastRecipes
                CategoryName.Lunch -> lunchRecipes
                CategoryName.Dinner -> dinnerRecipes
                CategoryName.Snacks -> snacks
            }
        )
        recipesGrid.layoutManager = GridLayoutManager(context, 2)
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
