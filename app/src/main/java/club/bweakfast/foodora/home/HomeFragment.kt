package club.bweakfast.foodora.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.R
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.browse.category.CategoryName
import club.bweakfast.foodora.getRandomRecipes
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_recipe_list.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topRecipesGrid.recyclerView.isNestedScrollingEnabled = false
        topRecipesGrid.recyclerView.adapter = RecipesAdapter(getRandomRecipes(20), true)
        topRecipesGrid.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        topBreakfastList.recyclerView.isNestedScrollingEnabled = false
        topBreakfastList.recyclerView.adapter = RecipesAdapter(getRandomRecipes(categories = listOf(CategoryName.Breakfast)))
        topBreakfastList.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        topLunchList.recyclerView.isNestedScrollingEnabled = false
        topLunchList.recyclerView.adapter = RecipesAdapter(getRandomRecipes(categories = listOf(CategoryName.Lunch)))
        topLunchList.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
