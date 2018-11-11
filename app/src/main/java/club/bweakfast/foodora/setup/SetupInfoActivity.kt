package club.bweakfast.foodora.setup

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.widget.ListView
import androidx.core.view.get
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.MainActivity
import club.bweakfast.foodora.ProcessingFragment
import club.bweakfast.foodora.R
import club.bweakfast.foodora.custom.CustomToolbarPreferenceActivity
import club.bweakfast.foodora.util.onError
import club.bweakfast.foodora.util.showFragment
import club.bweakfast.foodora.util.showView
import club.bweakfast.foodora.util.toast
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.pref_setup_input.view.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * A [PreferenceActivity] that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 *
 * See [Android Design: Settings](http://developer.android.com/design/patterns/settings.html)
 * for design guidelines and the [Settings API Guide](http://developer.android.com/guide/topics/ui/settings.html)
 * for more information on developing a Settings UI.
 */
class SetupInfoActivity : CustomToolbarPreferenceActivity() {
    @Inject
    lateinit var setupViewModel: SetupViewModel

    private val subscriptions = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FoodoraApp.daggerComponent.inject(this)
        showFragment(SetupInfoFragment(), containerID = android.R.id.content)

        setupViewModel.isSetupComplete = false
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        showView(rightIcon, true)

        fragmentManager.addOnBackStackChangedListener(::updateFragmentLook)
        updateFragmentLook()
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentManager.removeOnBackStackChangedListener(::updateFragmentLook)
        subscriptions.dispose()
    }

    private fun updateFragmentLook() {
        when (fragmentManager.backStackEntryCount) {
            0 -> {
                message = getString(R.string.message_setup_1)
                rightIcon.setImageResource(R.drawable.ic_arrow_right)
                rightIcon.setOnClickListener {
                    if (setupViewModel.isStep1Valid) showFragment(SetupMealsFragment(), "setupMeals", android.R.id.content)
                    else {
                        toast(R.string.error_setup_name)
                        val fragment = fragmentManager.findFragmentByTag("SetupInfoFragment") as SetupInfoFragment
                        (fragment.view.findViewById<ListView>(android.R.id.list)[0]).input.error = getString(R.string.error_field_required)
                    }
                }
            }
            1 -> {
                message = getString(R.string.message_setup_2)
                rightIcon.setImageResource(R.drawable.ic_check_circle_outline)
                leftIcon.setImageResource(R.drawable.ic_arrow_left)
                leftIcon.setOnClickListener { onBackPressed() }
                rightIcon.setOnClickListener {
                    if (setupViewModel.isStep2Valid) {
                        loadProcessingFragment()
                        subscriptions.add(
                            Completable.timer(2, TimeUnit.SECONDS)
                                .andThen(Completable.merge(listOf(setupViewModel.addAllergies())))
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe({
                                    setupViewModel.isSetupComplete = true
                                    Intent(this, MainActivity::class.java).apply {
                                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                                        startActivity(this)
                                        finish()
                                    }
                                }, {
                                    onError(it, this)
                                    onBackPressed()
                                    showToolbar(true)
                                })
                        )
                    } else {
                        toast(getString(R.string.error_setup_3_recipes))
                    }
                }
            }
        }
        showView(leftIcon, fragmentManager.backStackEntryCount > 0)
    }

    private fun loadProcessingFragment() {
        showToolbar(false)
        fragmentManager.beginTransaction().apply {
            val tag = "ProcessingFragment"
            replace(android.R.id.content, ProcessingFragment.newInstance(getString(R.string.loading_message_1)), tag)
            addToBackStack(tag)
            commit()
        }
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return PreferenceFragment::class.java.name == fragmentName || SetupInfoFragment::class.java.name == fragmentName ||
                SetupMealsFragment::class.java.name == fragmentName || ProcessingFragment::class.java.name == fragmentName
    }
}
