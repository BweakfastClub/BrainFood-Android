package club.bweakfast.foodora.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import club.bweakfast.foodora.R
import club.bweakfast.foodora.search.Recipe
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by silve on 3/20/2018.
 */

class RecipesAdapter(private val recipes: List<Recipe>) :
    RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        with(holder) {
            name.text = recipe.title
            image.setImageURI(recipe.imageURL)
        }
    }

    override fun getItemCount(): Int = recipes.size

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView by lazy { itemView.findViewById<TextView>(R.id.name) }
        val image: SimpleDraweeView by lazy {
            itemView.findViewById<SimpleDraweeView>(R.id.image)
        }
    }
}