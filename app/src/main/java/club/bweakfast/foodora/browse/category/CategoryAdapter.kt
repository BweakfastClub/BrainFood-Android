package club.bweakfast.foodora.browse.category

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import club.bweakfast.foodora.R
import club.bweakfast.foodora.browse.BrowseCategoryFragment
import club.bweakfast.foodora.showFragment
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by silve on 3/8/2018.
 */

class CategoryAdapter(val activity: FragmentActivity) : RecyclerView.Adapter<CategoryAdapter
.CategoryViewHolder>() {
    private val categories = listOf(
        Category(
            CategoryName.Breakfast,
            R.drawable.breakfast
        ),
        Category(
            CategoryName.Lunch,
            R.drawable.lunch
        ),
        Category(
            CategoryName.Dinner,
            R.drawable.dinner
        ),
        Category(
            CategoryName.Snacks,
            R.drawable.snacks
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        with(holder) {
            name.text = category.name.name
            image.setImageURI(category.imageURL)
            itemView.setOnClickListener {
                activity.showFragment(
                    BrowseCategoryFragment.newInstance(category.name),
                    "Browse${category.name}Fragment"
                )
            }
        }
    }

    override fun getItemCount(): Int = categories.size

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView by lazy { itemView.findViewById<TextView>(R.id.name) }
        val image: SimpleDraweeView by lazy { itemView.findViewById<SimpleDraweeView>(R.id.image) }
    }
}