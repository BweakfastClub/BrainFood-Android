package club.bweakfast.foodora

import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.runner.AndroidJUnit4
import club.bweakfast.foodora.di.component.DaggerFoodoraTestComponent
import club.bweakfast.foodora.di.module.FoodoraTestModule
import club.bweakfast.foodora.setup.SetupInfoActivity
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyString

@RunWith(AndroidJUnit4::class)
class SplashScreenActivityTest {
    @get:Rule
    val rule = IntentsTestRule(SplashScreenActivity::class.java, false, false)

    private val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext

    lateinit var preferences: SharedPreferences

    @Before
    fun setup() {
        FoodoraApp.daggerComponent = DaggerFoodoraTestComponent
            .builder()
            .foodoraTestModule(FoodoraTestModule(context))
            .build()
            .apply {
                preferences = sharedPreferences()
            }
    }

    @Test
    fun verifySetupScreenLoadedWhenSetupNotComplete() {
        whenever(preferences.getBoolean(anyString(), anyBoolean())).thenReturn(false)
        rule.launchActivity(null)
        Thread.sleep(2000)
        SetupInfoActivity::class.java.verifyIntent()
    }

    @Test
    fun verifyHomeScreenLoadedWhenSetupComplete() {
        whenever(preferences.getBoolean(anyString(), anyBoolean())).thenReturn(true)
        rule.launchActivity(null)
        Thread.sleep(2000)
        MainActivity::class.java.verifyIntent()
    }
}