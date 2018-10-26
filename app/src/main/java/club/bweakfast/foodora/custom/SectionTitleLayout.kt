package club.bweakfast.foodora.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.use
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.view_section_title.view.*

open class SectionTitleLayout(context: Context, attrs: AttributeSet?, defStyle: Int) : LinearLayout(context, attrs, defStyle) {
    var titleTxt: TextView
    var title: String = ""
        set(value) {
            titleTxt.text = value
        }

    init {
        val sectionTitleLayout = LayoutInflater.from(context).inflate(R.layout.view_section_title, this, false)
        titleTxt = sectionTitleLayout.titleTxt

        // Load attributes
        context.obtainStyledAttributes(attrs, R.styleable.SectionTitleLayout, defStyle, 0).use {
            title = it.getString(R.styleable.SectionTitleLayout_title)
        }

        orientation = LinearLayout.VERTICAL
        addView(sectionTitleLayout)
    }

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)
}