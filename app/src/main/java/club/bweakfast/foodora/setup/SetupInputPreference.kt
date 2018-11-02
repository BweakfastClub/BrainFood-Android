package club.bweakfast.foodora.setup

import android.content.Context
import android.preference.Preference
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.content.res.use
import club.bweakfast.foodora.R

class SetupInputPreference(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : Preference(context, attrs, defStyleAttr) {
    var inputWidth = 0f
    var inputType = 0

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        layoutResource = R.layout.pref_setup_input
        context?.theme?.obtainStyledAttributes(attrs, R.styleable.SetupInputPreference, defStyleAttr, 0)?.use {
            inputWidth = it.getDimension(R.styleable.SetupInputPreference_inputWidth, 0f)
            inputType = it.getInt(R.styleable.SetupInputPreference_android_inputType, EditorInfo.TYPE_NULL)
        }
    }

    override fun onBindView(view: View?) {
        super.onBindView(view)
        view?.findViewById<EditText>(R.id.input)?.apply {
            layoutParams?.width = inputWidth.toInt()
            this.inputType = this@SetupInputPreference.inputType
        }
    }
}