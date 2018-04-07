package club.bweakfast.foodora

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.use
import kotlinx.android.synthetic.main.layout_two_line.view.*


/**
 * Created by silve on 3/26/2018.
 */

class TwoLineText constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        val attributes = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TwoLineText,
            0,
            0
        )

        LayoutInflater.from(context).inflate(R.layout.layout_two_line, this, true)

        attributes.use {
            text1.text = it.getString(R.styleable.TwoLineText_text1)
            text2.text = it.getString(R.styleable.TwoLineText_text2)
        }

        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
    }

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
}