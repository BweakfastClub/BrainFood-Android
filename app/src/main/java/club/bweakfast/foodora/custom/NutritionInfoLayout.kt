package club.bweakfast.foodora.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.res.use
import club.bweakfast.foodora.R
import kotlinx.android.synthetic.main.layout_two_line.view.*

class NutritionInfoLayout(context: Context, attrs: AttributeSet?, defStyle: Int) : LinearLayout(context, attrs, defStyle) {
    var nutritionInfo1: Pair<String, String>? = null
        set(value) {
            setNutritionInfo(0, value)
        }
    var nutritionInfo2: Pair<String, String>? = null
        set(value) {
            setNutritionInfo(1, value)
        }
    var nutritionInfo3: Pair<String, String>? = null
        set(value) {
            setNutritionInfo(2, value)
        }
    var nutritionInfo4: Pair<String, String>? = null
        set(value) {
            setNutritionInfo(3, value)
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_nutrition_info, this, true)

        context.theme.obtainStyledAttributes(attrs, R.styleable.NutritionInfoLayout, 0, 0).use {
            nutritionInfo1 = it.getString(R.styleable.NutritionInfoLayout_nutrName1) to it.getString(R.styleable.NutritionInfoLayout_nutrValue1)
            nutritionInfo2 = it.getString(R.styleable.NutritionInfoLayout_nutrName2) to it.getString(R.styleable.NutritionInfoLayout_nutrValue2)
            nutritionInfo3 = it.getString(R.styleable.NutritionInfoLayout_nutrName3) to it.getString(R.styleable.NutritionInfoLayout_nutrValue3)
            nutritionInfo4 = it.getString(R.styleable.NutritionInfoLayout_nutrName4) to it.getString(R.styleable.NutritionInfoLayout_nutrValue4)
        }

        orientation = LinearLayout.HORIZONTAL
        isBaselineAligned = false
    }

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

    private fun setNutritionInfo(index: Int, info: Pair<String, String>?) {
        val nutritionLayouts = listOf(R.id.nutritionTxt1, R.id.nutritionTxt2, R.id.nutritionTxt3, R.id.nutritionTxt4)
        val nutritionTxt = findViewById<TwoLineText>(nutritionLayouts[index])

        if (info != null) {
            nutritionTxt.text1.text = info.first
            nutritionTxt.text2.text = info.second
        } else {
            nutritionTxt.visibility = View.GONE
        }
    }
}