package club.bweakfast.foodora

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.runner.AndroidJUnit4
import club.bweakfast.foodora.auth.AuthenticationActivity
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.di.component.DaggerFoodoraTestComponent
import club.bweakfast.foodora.di.module.FoodoraTestModule
import club.bweakfast.foodora.settings.SettingsActivity
import club.bweakfast.foodora.user.ProfileActivity
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val rule = IntentsTestRule(MainActivity::class.java, true, false)

    private val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext

    lateinit var authService: AuthenticationService

    @Before
    fun setup() {
        FoodoraApp.daggerComponent = DaggerFoodoraTestComponent
            .builder()
            .foodoraTestModule(FoodoraTestModule(context))
            .build()
            .apply {
                authService = authService()
            }
    }

    @Test
    fun loadProfileScreen() {
        whenever(authService.isLoggedIn).doReturn(true)
        rule.launchActivity(null)
        R.id.leftIcon.performClick()
        ProfileActivity::class.java.verifyIntent()
    }

    @Test
    fun loadAuthScreen() {
        whenever(authService.isLoggedIn).doReturn(false)
        rule.launchActivity(null)
        R.id.leftIcon.performClick()
        AuthenticationActivity::class.java.verifyIntent()
    }

    @Test
    fun loadSettingsScreen() {
        whenever(authService.isLoggedIn).doReturn(true)
        rule.launchActivity(null)
        R.id.rightIcon.performClick()
        SettingsActivity::class.java.verifyIntent()
    }

    @Test
    fun loadHomeScreen() {
        rule.launchActivity(null)
        R.id.tab_search.performClick()
        R.id.tab_home.performClick()
        R.id.titleTxt.validateText("BrainFood")
        R.id.messageTxt.checkIsVisible()
        R.id.messageTxt.validateText("Good morning! In the mood for some new breakfast ideas?")
        R.id.searchBox.checkIsGone()
    }

    @Test
    fun loadSearchScreen() {
        rule.launchActivity(null)
        R.id.tab_search.performClick()
        R.id.messageTxt.checkIsGone()
        R.id.searchBox.checkIsVisible()
        R.id.titleTxt.validateText("Search")
    }

    @Test
    fun loadMealPlanScreen() {
        rule.launchActivity(null)
        R.id.tab_plan.performClick()
        R.id.searchBox.checkIsGone()
        R.id.messageTxt.checkIsVisible()
        R.id.messageTxt.validateText("Here's a little meal plan I cooked up today!")
        R.id.titleTxt.validateText("Meal Plan")
    }
}