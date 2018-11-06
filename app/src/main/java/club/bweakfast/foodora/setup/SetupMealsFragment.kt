package club.bweakfast.foodora.setup

import android.os.Build
import android.os.Bundle
import android.preference.PreferenceFragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R
import club.bweakfast.foodora.getRandomRecipes
import club.bweakfast.foodora.recipe.SelectableRecipesAdapter
import kotlinx.android.synthetic.main.pref_fragment_setup_meals.*
import javax.inject.Inject

class SetupMealsFragment : PreferenceFragment() {
    @Inject
    lateinit var setupViewModel: SetupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FoodoraApp.daggerComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.pref_fragment_setup_meals, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipes = getRandomRecipes(8)
        mealsGrid.recyclerView.adapter = SelectableRecipesAdapter(recipes, true) { recipeCount ->
            setupViewModel.isStep2Valid = recipeCount >= 3
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mealsGrid.recyclerView.layoutManager = GridLayoutManager(context, 2)
        }
    }
}