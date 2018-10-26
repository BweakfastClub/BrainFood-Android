package club.bweakfast.foodora.recipe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.fragment_recipes_list.*
import kotlin.properties.Delegates

abstract class RecipesListFragment : Fragment() {
    private lateinit var recipesAdapter: RecipesAdapter
    protected var recipes by Delegates.observable<List<Recipe>>(emptyList()) { _, _, newValue ->
        if (::recipesAdapter.isInitialized) {
            recipesAdapter.submitList(newValue)
        } else {
            recipesAdapter = RecipesAdapter(newValue)
            recipesGrid.adapter = recipesAdapter
            recipesGrid.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    final override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_list, container, false)
    }
}