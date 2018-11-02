package club.bweakfast.foodora.setup

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceFragment
import android.widget.ListView
import club.bweakfast.foodora.R

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class SetupInfoFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref_setup_info)
        setHasOptionsMenu(false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view.findViewById<ListView>(android.R.id.list).divider = null
    }
}