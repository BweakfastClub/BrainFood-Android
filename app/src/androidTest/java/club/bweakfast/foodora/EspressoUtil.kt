package club.bweakfast.foodora

import android.app.Activity
import android.content.res.Resources
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.hasErrorText
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.hamcrest.TypeSafeMatcher


fun ViewInteraction.performClick(): ViewInteraction = perform(ViewActions.click())

fun ViewInteraction.checkVisibility(visibility: ViewMatchers.Visibility): ViewInteraction {
    return check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility)))
}

fun ViewInteraction.validateText(text: String): ViewInteraction = check(matches(withText(text)))

fun ViewInteraction.validateErrorText(text: String): ViewInteraction = check(matches(hasErrorText(text)))

fun ViewInteraction.typeInputText(text: String): ViewInteraction = performClick().perform(typeText(text))

fun ViewInteraction.closeKeyboard(): ViewInteraction = perform(closeSoftKeyboard())

fun String.matchView(): ViewInteraction = onView(withText(this))

fun String.performClick() = matchView().performClick()

fun Int.matchView(): ViewInteraction = onView(withId(this))

fun Int.performClick() = matchView().performClick()

fun Int.checkIsVisible() = matchView().checkVisibility(ViewMatchers.Visibility.VISIBLE)

fun Int.checkIsGone() = matchView().checkVisibility(ViewMatchers.Visibility.GONE)

fun Int.validateText(text: String) = matchView().validateText(text)

fun Int.validateErrorText(text: String) = matchView().validateErrorText(text)

fun Int.typeInputText(text: String) = matchView().typeInputText(text)

fun Int.closeKeyboard() = matchView().closeKeyboard()

fun Class<out Activity>.verifyIntent() {
    intended(hasComponent(this.name))
}

fun <T : Activity> checkIsToastDisplayed(text: String, activityRule: ActivityTestRule<T>): ViewInteraction {
    return onView(withText(text))
        .inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
        .check(matches(isDisplayed()))
}

fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
    return RecyclerViewMatcher(recyclerViewId)
}

class RecyclerViewMatcher(internal val mRecyclerViewId: Int) {
    fun atPosition(position: Int): Matcher<View> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(position: Int, targetViewId: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            var resources: Resources? = null
            var childView: View? = null

            override fun describeTo(description: Description) {
                val id = if (targetViewId == -1) mRecyclerViewId else targetViewId
                var idDescription = Integer.toString(id)
                if (this.resources != null) {
                    idDescription = try {
                        this.resources!!.getResourceName(id)
                    } catch (var4: Resources.NotFoundException) {
                        String.format("%s (resource name not found)", id)
                    }

                }

                description.appendText("with id: $idDescription")
            }

            override fun matchesSafely(view: View): Boolean {
                this.resources = view.resources

                if (childView == null) {
                    val recyclerView = view.rootView.findViewById(mRecyclerViewId) as RecyclerView
                    if (recyclerView != null) {
                        childView = recyclerView.findViewHolderForAdapterPosition(position).itemView
                    } else {
                        return false
                    }
                }

                return if (targetViewId == -1) {
                    view === childView
                } else {
                    val targetView = childView!!.findViewById<View>(targetViewId)
                    view === targetView
                }

            }
        }
    }
}