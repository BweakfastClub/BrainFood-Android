package club.bweakfast.foodora.custom

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import kotlin.math.min

class ExtendedFabBehaviour(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<Button>(context, attrs) {
    override fun layoutDependsOn(parent: CoordinatorLayout?, child: Button?, dependency: View?): Boolean {
        return dependency is Snackbar.SnackbarLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: Button, dependency: View): Boolean {
        val translationY = min(0f, dependency.translationY - dependency.height)
        child.translationY = translationY
        return true
    }
}