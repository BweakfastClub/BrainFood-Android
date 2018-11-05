package club.bweakfast.foodora.setup

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import club.bweakfast.foodora.CustomToolbarPreferenceActivity
import club.bweakfast.foodora.MainActivity
import club.bweakfast.foodora.R
import club.bweakfast.foodora.util.showFragment
import club.bweakfast.foodora.util.showView

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showFragment(SetupInfoFragment(), containerID = android.R.id.content)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        showView(rightIcon, true)

        fragmentManager.addOnBackStackChangedListener(::updateFragmentLook)
        rightIcon.setOnClickListener { showFragment(SetupMealsFragment(), "setupMeals", android.R.id.content) }
        updateFragmentLook()
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentManager.removeOnBackStackChangedListener(::updateFragmentLook)
    }

    private fun updateFragmentLook() {
        when (fragmentManager.backStackEntryCount) {
            0 -> {
                message = getString(R.string.message_setup_1)
                rightIcon.setImageResource(R.drawable.ic_arrow_right)
            }
            1 -> {
                message = getString(R.string.message_setup_2)
                rightIcon.setImageResource(R.drawable.ic_check_circle_outline)
                leftIcon.setImageResource(R.drawable.ic_arrow_left)
                leftIcon.setOnClickListener { onBackPressed() }
                rightIcon.setOnClickListener {
                    Intent(this, MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(this)
                        finish()
                    }
                }
            }
        }
        showView(leftIcon, fragmentManager.backStackEntryCount > 0)
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return PreferenceFragment::class.java.name == fragmentName || SetupInfoFragment::class.java.name == fragmentName
    }
}
