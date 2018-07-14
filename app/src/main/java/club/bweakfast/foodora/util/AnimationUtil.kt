package club.bweakfast.foodora.util

import android.view.View
import android.widget.ProgressBar
import io.reactivex.Completable

/**
 * Created by silve on 3/2/2018.
 */

var runningAnimation: Completable? = null

fun showProgress(show: Boolean, progressView: ProgressBar, layoutView: View) {
    val showView = if (show) progressView else layoutView
    val hideView = if (show) layoutView else progressView

    showView.visibility = View.VISIBLE
    hideView.visibility = View.GONE
//    return fadeAnimation(showView, hideView)
}

fun fadeAnimation(showView: View, hideView: View): Completable {
    val animTime = showView
        .context
        .applicationContext
        .resources
        .getInteger(android.R.integer.config_shortAnimTime)
        .toLong()

    showView.alpha = 0f
    showView.visibility = View.VISIBLE

    val showAnimation = Completable.create {
        showView.animate()
            .setDuration(animTime)
            .alpha(0f)
            .withEndAction(it::onComplete)
    }
    val hideAnimation = Completable.create {
        hideView.animate()
            .setDuration(animTime)
            .alpha(1f)
            .withEndAction {
                hideView.visibility = View.GONE
                it.onComplete()
            }
    }

    val currentAnimation = Completable.merge(listOf(showAnimation, hideAnimation))
    runningAnimation = runningAnimation?.andThen(currentAnimation) ?: currentAnimation
    return runningAnimation!!
}