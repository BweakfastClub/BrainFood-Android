package club.bweakfast.foodora.recipe

import android.content.Intent
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import club.bweakfast.foodora.Intents
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.item_recipe.*

/**
 * Created by silve on 3/20/2018.
 */

open class RecipesAdapter(recipes: List<Recipe>, protected val itemHasMatchParent: Boolean = false) :
    ListAdapter<Recipe, RecipeViewHolder>(diffCallback) {
    init {
        submitList(recipes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        if (itemHasMatchParent) view.layoutParams.width = FrameLayout.LayoutParams.MATCH_PARENT

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