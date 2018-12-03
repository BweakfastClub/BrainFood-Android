package club.bweakfast.foodora.settings

import android.os.Bundle
import android.support.v14.preference.PreferenceFragment
import android.support.v7.widget.RecyclerView
import android.view.View
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.R

class SettingsFragment : PreferenceFragment() {
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
    }
}