package club.bweakfast.foodora.category

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.item_select_category.*

class CategoryAdapter(private val categoryListener: (String, Boolean) -> Unit = { _, _ -> }) : RecyclerView.Adapter<CategoryViewHolder>() {
    private val categories = CategoryName.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_select_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        with(holder) {
            val category = categories[position]
            val categoryName = category.name.toLowerCase()
            this.categorySelect.text = categoryName.capitalize()
            this.categorySelect.setOnClickListener {
                val checkbox = (it as TextView)
                val rightDrawable = checkbox.compoundDrawables[2]
                val isChecked = rightDrawable == null // If right drawable is initially null, then the "checkbox" is being set to true
                val drawableID = if (rightDrawable == null) R.drawable.ic_check else 0

                checkbox.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableID, 0)
                categoryListener(categoryName, isChecked)
            }
        }
    }

    override fun getItemCount() = categories.size
}