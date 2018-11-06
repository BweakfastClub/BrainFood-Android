package club.bweakfast.foodora.setup

import android.content.Context
import android.support.v7.preference.Preference
import android.support.v7.preference.PreferenceViewHolder
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.core.content.res.use
import club.bweakfast.foodora.R

class SetupInputPreference(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : Preference(context, attrs, defStyleAttr) {
    var inputWidth = 0f
    var inputType = 0

    private val textWatcher: TextWatcher

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        layoutResource = R.layout.pref_setup_input
        context.theme?.obtainStyledAttributes(attrs, R.styleable.SetupInputPreference, defStyleAttr, 0)?.use {
            inputWidth = it.getDimension(R.styleable.SetupInputPreference_inputWidth, 0f)
            inputType = it.getInt(R.styleable.SetupInputPreference_android_inputType, EditorInfo.TYPE_NULL)
        }

        textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                persistString(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder?) {
        super.onBindViewHolder(holder)
        holder?.itemView?.findViewById<EditText>(R.id.input)?.apply {
            layoutParams?.width = inputWidth.toInt()
            this.inputType = this@SetupInputPreference.inputType
            this.text = SpannableStringBuilder(getPersistedString(""))
            this.addTextChangedListener(textWatcher)
        }
    }
}