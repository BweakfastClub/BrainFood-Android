package club.bweakfast.foodora.recipe

import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.item_recipe.*

class SelectableRecipesAdapter(recipes: List<Recipe>, itemHasMatchParent: Boolean, private val recipeSelectedListener: (Int) -> Unit) :
    RecipesAdapter(recipes, itemHasMatchParent) {
    private val selectedRecipes = mutableSetOf<Int>()

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val recipe = getItem(position)
        with(holder) {
            itemView.setOnClickListener {
                val action = if (selectedRecipes.contains(recipe.id)) selectedRecipes::remove else selectedRecipes::add
                action.invoke(recipe.id)
                recipeSelectedListener.invoke(selectedRecipes.size)

                val textColor: Int
                if (selectedRecipes.contains(recipe.id)) {
                    textColor = R.color.black
                    image.setColorFilter(ContextCompat.getColor(it.context, R.color.translucentOverlay3), PorterDuff.Mode.MULTIPLY)
                } else {
                    textColor = R.color.white
                    image.setColorFilter(ContextCompat.getColor(it.context, R.color.translucentOverlay), PorterDuff.Mode.DARKEN)
                }
                name.setTextColor(ContextCompat.getColor(it.context, textColor))
            }
        }
    }
}