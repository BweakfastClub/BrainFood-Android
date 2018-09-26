package club.bweakfast.foodora.recipe.ingredient

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import club.bweakfast.foodora.R


class IngredientAdapter(private val ingredients: List<Ingredient>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            viewType,
            parent,
            false
        )

        return if (viewType == R.layout.item_ingredient) {
            IngredientViewHolder(view)
        } else {
            IngredientHeaderViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val ingredient = ingredients[position]
        val ingredientText = when (holder) {
            is IngredientViewHolder -> holder.ingredientText
            is IngredientHeaderViewHolder -> holder.ingredientHeader
            else -> throw IllegalArgumentException("Invalid holder")
        }

        ingredientText.text = ingredient.name
    }

    override fun getItemViewType(position: Int): Int {
        val ingredient = ingredients[position]
        return if (ingredient.displayType == "Heading") {
            R.layout.item_ingredient_header
        } else {
            R.layout.item_ingredient
        }
    }

    override fun getItemCount(): Int = ingredients.size
}