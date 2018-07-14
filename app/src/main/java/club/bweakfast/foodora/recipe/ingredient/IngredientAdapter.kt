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

        if (holder is IngredientViewHolder) {
            val text = if (ingredient.name.isNotBlank()) holder.itemView.context.getString(
                R.string.ingredient_template,
                ingredient.name
            ) else ""
            holder.ingredientText.text = text
        } else if (holder is IngredientHeaderViewHolder) {
            holder.ingredientHeader.text = ingredient.name
        }
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