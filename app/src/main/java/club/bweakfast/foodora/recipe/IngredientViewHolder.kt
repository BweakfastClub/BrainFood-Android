package club.bweakfast.foodora.recipe

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import club.bweakfast.foodora.R


class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ingredientText: TextView by lazy { itemView.findViewById<TextView>(R.id.ingredientText) }
}