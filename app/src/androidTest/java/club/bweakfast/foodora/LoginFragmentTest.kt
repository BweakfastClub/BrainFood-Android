package club.bweakfast.foodora

import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import club.bweakfast.foodora.auth.AuthenticationActivity
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.auth.TokenResponse
import club.bweakfast.foodora.di.component.DaggerFoodoraTestComponent
import club.bweakfast.foodora.di.module.FoodoraTestModule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyMap
import org.mockito.ArgumentMatchers.anyString
import retrofit2.Response

class LoginFragmentTest {
    @get:Rule
    val rule = ActivityTestRule(AuthenticationActivity::class.java, true, false)

    private val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext

    lateinit var preferences: SharedPreferences
    lateinit var authService: AuthenticationService

    @Before
    fun setup() {
        FoodoraApp.daggerComponent = DaggerFoodoraTestComponent
            .builder()
            .foodoraTestModule(FoodoraTestModule(context))
            .build()
            .apply {
                preferences = sharedPreferences()
                authService = authService()
            }
        whenever(preferences.contains(anyString())).doReturn(false)
    }

    @Test
    fun testBlankInputs() {
        rule.launchActivity(null)
        R.id.loginButton.performClick()
        R.id.email.matchView().validateErrorText("This field is required")
        R.id.password.matchView().validateErrorText("This field is required").closeKeyboard()
    }

    @Test
    fun testInvalidInputs() {
        rule.launchActivity(null)
        R.id.email.typeInputText("a")
        R.id.password.typeInputText("a").closeKeyboard()
        R.id.loginButton.performClick()
        R.id.email.validateErrorText("This email address is invalid")
        R.id.password.validateErrorText("This password is too short")
    }

    @Test
    fun testInvalidUsernamePassword() {
        whenever(authService.api.login(anyMap())).doReturn(Single.just(Response.error<TokenResponse>(401, ResponseBody.create(null, ""))))
        rule.launchActivity(null)
        R.id.email.typeInputText("banana@apple.ca")
        R.id.password.typeInputText("banana").closeKeyboard()
        R.id.loginButton.performClick()
        checkIsToastDisplayed("Invalid username/password combination", rule)
    }
}