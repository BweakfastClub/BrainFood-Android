package club.bweakfast.foodora.custom

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.use
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.view_section_title.view.*

/**
 * TODO: document your custom view class.
 */
class RecipeListView(context: Context, attrs: AttributeSet?, defStyle: Int) : SectionTitleLayout(context, attrs, defStyle) {
    val recyclerView = RecyclerView(context)

    init {
        addView(recyclerView)
    }

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
}
