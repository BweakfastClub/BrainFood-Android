package club.bweakfast.foodora.settings

import android.content.Intent
import android.os.Bundle
import android.support.v14.preference.PreferenceFragment
import android.support.v7.preference.PreferenceGroupAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.MainActivity
import club.bweakfast.foodora.R
import javax.inject.Inject

class SettingsFragment : PreferenceFragment() {
    @Inject
    lateinit var settingsViewModel: SettingsViewModel

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_settings)
        setHasOptionsMenu(false)

        FoodoraApp.daggerComponent.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = view?.findViewById<RecyclerView>(R.id.list)
        val divider = list?.getItemDecorationAt(0)
        list?.removeItemDecoration(divider)

        (list?.adapter as PreferenceGroupAdapter).getItem(7).setOnPreferenceClickListener {
            settingsViewModel.logout()
            Intent(activity, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
                activity.finish()
            }
            true
        }
    }
}