package club.bweakfast.foodora.setup

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.v14.preference.PreferenceFragment
import android.support.v7.widget.RecyclerView
import android.view.View
import club.bweakfast.foodora.R

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
class SetupInfoFragment : PreferenceFragment() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_setup_info)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = view?.findViewById<RecyclerView>(R.id.list)
        val divider = list?.getItemDecorationAt(0)
        list?.removeItemDecoration(divider)
    }
}