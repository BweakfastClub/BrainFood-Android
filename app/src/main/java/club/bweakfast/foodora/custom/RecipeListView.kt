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
class RecipeListView : SectionTitleLayout {
    lateinit var recyclerView: RecyclerView
        private set

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    override fun init(attrs: AttributeSet?, defStyle: Int) {
        super.init(attrs, defStyle)

        recyclerView = RecyclerView(context)
        addView(recyclerView)
    }
}
