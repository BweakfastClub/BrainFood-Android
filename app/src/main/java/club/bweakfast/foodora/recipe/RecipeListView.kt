package club.bweakfast.foodora.recipe

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.use
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.view_recipe_list.view.*

/**
 * TODO: document your custom view class.
 */
class RecipeListView : LinearLayout {
    var title: String = ""
        set(value) {
            titleTxt.text = value
        }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        LayoutInflater.from(context).inflate(R.layout.view_recipe_list, this, true)

        // Load attributes
        context.obtainStyledAttributes(attrs, R.styleable.RecipeListView, defStyle, 0).use {
            title = it.getString(R.styleable.RecipeListView_title)
        }

        orientation = LinearLayout.VERTICAL
    }
}
