package club.bweakfast.foodora.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.use
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.view_section_title.view.*

open class SectionTitleLayout : LinearLayout {
    lateinit var titleTxt: TextView
    var title: String = ""
        set(value) {
            titleTxt.text = value
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    protected open fun init(attrs: AttributeSet?, defStyle: Int) {
        val sectionTitleLayout = LayoutInflater.from(context).inflate(R.layout.view_section_title, this, false)
        titleTxt = sectionTitleLayout.titleTxt

        // Load attributes
        context.obtainStyledAttributes(attrs, R.styleable.SectionTitleLayout, defStyle, 0).use {
            title = it.getString(R.styleable.SectionTitleLayout_title)
        }

        orientation = LinearLayout.VERTICAL
        addView(sectionTitleLayout)
    }
}