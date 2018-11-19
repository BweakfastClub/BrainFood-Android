package club.bweakfast.foodora

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.intent.rule.IntentsTestRule
import club.bweakfast.foodora.di.component.DaggerFoodoraTestComponent
import club.bweakfast.foodora.di.module.FoodoraTestModule
import club.bweakfast.foodora.setup.SetupInfoActivity
import club.bweakfast.foodora.setup.SetupViewModel
import club.bweakfast.foodora.util.isToastDisplayed
import club.bweakfast.foodora.util.toastIdlingResource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SetupActivityTest {
    @get:Rule
    val rule = IntentsTestRule(SetupInfoActivity::class.java, true, false)

    private val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext

    lateinit var setupViewModel: SetupViewModel

    @Before
    fun setup() {
        FoodoraApp.daggerComponent = DaggerFoodoraTestComponent
            .builder()
            .foodoraTestModule(FoodoraTestModule(context))
            .build()
            .apply {
                setupViewModel = setupViewModel()
            }
        IdlingRegistry.getInstance().register(toastIdlingResource)
    }

    @After
    fun cleanUp() {
        IdlingRegistry.getInstance().unregister(toastIdlingResource)
    }

    @Test
    fun testShowToastWhenVeganAndVegetarianSelected() {
        whenever(setupViewModel.isStep1Valid).doReturn(false)
        rule.launchActivity(null)
        R.id.messageTxt.validateText("Fill in the following information, it\'ll help us figure out how to feed you!")
        R.id.rightIcon.performClick()
        checkIsToastDisplayed("Please select either vegan or vegetarian", rule)
        if (isToastDisplayed) toastIdlingResource.increment()
    }

    @Test
    fun testGoToStep2WhenAllInformationIsValid() {
        whenever(setupViewModel.isStep1Valid).doReturn(true)
        rule.launchActivity(null)
        R.id.rightIcon.performClick()
        R.id.messageTxt.validateText("To start, select at least 3 of the meals that you think you\'d enjoy eating!")
        R.id.leftIcon.performClick()
        R.id.messageTxt.validateText("Fill in the following information, it\'ll help us figure out how to feed you!")
    }

    @Test
    fun testShowToastWhenLessThan3RecipesAreSelected() {
        whenever(setupViewModel.isStep1Valid).doReturn(true)
        whenever(setupViewModel.isStep2Valid).doReturn(false)
        rule.launchActivity(null)
        R.id.rightIcon.performClick()
        R.id.rightIcon.performClick()
        checkIsToastDisplayed("You must select 3 recipes to continue!", rule)
        if (isToastDisplayed) toastIdlingResource.increment()
    }

    @Test
    fun testGoToHomeScreenWhen3OrMoreRecipesAreSelected() {
        whenever(setupViewModel.isStep1Valid).doReturn(true)
        whenever(setupViewModel.isStep2Valid).doReturn(true)
        rule.launchActivity(null)
        R.id.rightIcon.performClick()
        R.id.rightIcon.performClick()
        Thread.sleep(2500)
        MainActivity::class.java.verifyIntent()
    }
}