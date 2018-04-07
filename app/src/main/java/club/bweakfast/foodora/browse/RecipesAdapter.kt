package club.bweakfast.foodora.browse

import android.content.Intent
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import club.bweakfast.foodora.Intents
import club.bweakfast.foodora.R
import club.bweakfast.foodora.recipe.Recipe
import club.bweakfast.foodora.recipe.RecipeActivity
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by silve on 3/20/2018.
 */

class RecipesAdapter(recipes: List<Recipe>) :
    ListAdapter<Recipe, RecipesAdapter.RecipeViewHolder>(diffCallback) {

    init {
        submitList(recipes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position)
        with(holder) {
            name.text = recipe.title
            image.setImageURI(recipe.imageURL)
            itemView.setOnClickListener {
                val intent = Intent(it.context, RecipeActivity::class.java)
                intent.putExtra(Intents.INTENT_RECIPE_ACTIVITY, recipe)
                it.context.startActivity(intent)
            }
        }
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView by lazy { itemView.findViewById<TextView>(R.id.name) }
        val image: SimpleDraweeView by lazy { itemView.findViewById<SimpleDraweeView>(R.id.image) }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Recipe>() {
            override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                return oldItem == newItem
            }
        }
    }
}