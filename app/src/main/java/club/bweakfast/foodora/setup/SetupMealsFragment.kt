package club.bweakfast.foodora.setup

import android.os.Bundle
import android.support.v14.preference.PreferenceFragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R
import club.bweakfast.foodora.getRandomRecipes
import club.bweakfast.foodora.recipe.SelectableRecipesAdapter
import club.bweakfast.foodora.util.onError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.pref_fragment_setup_meals.*
import javax.inject.Inject

class SetupMealsFragment : PreferenceFragment() {
    @Inject
    lateinit var setupViewModel: SetupViewModel

    private lateinit var disposable: Disposable

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        FoodoraApp.daggerComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.pref_fragment_setup_meals, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        disposable = setupViewModel.getRandomRecipes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { recipes, err ->
                if (err != null) {
                    onError(err, activity)
                } else {
                    mealsGrid.recyclerView.adapter = SelectableRecipesAdapter(recipes, true) { recipeCount ->
                        setupViewModel.isStep2Valid = recipeCount >= 3
                    }
                    mealsGrid.recyclerView.layoutManager = GridLayoutManager(activity, 2)
                }
            }
    }

    override fun onDestroyView() {
        disposable.dispose()
        super.onDestroyView()
    }
}