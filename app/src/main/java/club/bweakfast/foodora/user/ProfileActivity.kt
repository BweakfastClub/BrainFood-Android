package club.bweakfast.foodora.user

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import club.bweakfast.foodora.R
import club.bweakfast.foodora.custom.CustomToolbarActivity
import club.bweakfast.foodora.getRandomRecipes
import club.bweakfast.foodora.recipe.RecipesAdapter
import club.bweakfast.foodora.util.onError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.content_profile.*

class ProfileActivity : CustomToolbarActivity() {
    private lateinit var disposable: Disposable

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, R.layout.activity_profile)

        message = getString(R.string.message_profile)
        title = getString(R.string.title_profile)

        disposable = recipeViewModel.getFavouriteRecipes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { recipes, err ->
                if (err != null) {
                    onError(err, this)
                } else {
                    pinnedMealsList.recyclerView.adapter = RecipesAdapter(recipes, true)
                    pinnedMealsList.recyclerView.layoutManager = LinearLayoutManager(this)
                }
            }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
