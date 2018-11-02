package club.bweakfast.foodora.setup

import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.view.Menu
import android.view.MenuItem
import club.bweakfast.foodora.CustomToolbarPreferenceActivity
import club.bweakfast.foodora.R
import club.bweakfast.foodora.util.showFragment

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

        showFragment(SetupInfoFragment(), android.R.id.content)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        message = getString(R.string.message_setup_1)
        rightIcon.setImageResource(R.drawable.ic_arrow_right)
        rightIcon.setOnClickListener {
            showFragment(SetupMealsFragment(), android.R.id.content, "setupMeals")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_next -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return PreferenceFragment::class.java.name == fragmentName || SetupInfoFragment::class.java.name == fragmentName
    }
}
