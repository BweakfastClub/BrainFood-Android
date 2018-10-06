package club.bweakfast.foodora.user

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import club.bweakfast.foodora.CustomToolbarActivity
import club.bweakfast.foodora.R
import club.bweakfast.foodora.getRandomRecipes
import club.bweakfast.foodora.recipe.RecipesAdapter
import kotlinx.android.synthetic.main.content_profile.*

class ProfileActivity : CustomToolbarActivity() {
    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, R.layout.activity_profile)

        message = getString(R.string.message_profile)

        pinnedMealsList.recyclerView.adapter = RecipesAdapter(getRandomRecipes(3), true)
        pinnedMealsList.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
