package club.bweakfast.foodora.settings

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceFragment
import android.support.v7.preference.PreferenceManager
import android.support.v7.widget.RecyclerView
import androidx.core.view.get
import club.bweakfast.foodora.FoodoraApp
import club.bweakfast.foodora.MainActivity
import club.bweakfast.foodora.R
import club.bweakfast.foodora.custom.CustomToolbarPreferenceActivity
import club.bweakfast.foodora.util.buildBottomSheet
import club.bweakfast.foodora.util.onError
import club.bweakfast.foodora.util.parseError
import club.bweakfast.foodora.util.showFragment
import club.bweakfast.foodora.util.showView
import club.bweakfast.foodora.util.toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.pref_setup_input.view.*
import retrofit2.HttpException
import javax.inject.Inject

class SettingsActivity : CustomToolbarPreferenceActivity() {
    @Inject
    lateinit var settingsViewModel: SettingsViewModel

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FoodoraApp.daggerComponent.inject(this)
        showFragment(SettingsFragment(), containerID = android.R.id.content)

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(settingsViewModel.preferenceChangeListener)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        title = getString(R.string.title_settings)
        showView(rightIcon, true)
        rightIcon.setImageResource(R.drawable.ic_check_circle_outline)
        rightIcon.setOnClickListener {
            if (settingsViewModel.isSettingsValid) {
                val dialog = ProgressDialog.show(this, "", getString(R.string.msg_submitting_changes))
                disposable = settingsViewModel.saveChanges()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        dialog.hide()
                        toast(R.string.msg_saved_changes)
                        finish()
                    }, {
                        dialog.hide()
                        onError(it, this) { _, error ->
                            var message = getString(R.string.error_occurred)

                            if (error is HttpException) {
                                val errorMessage = parseError(error.response().errorBody())
                                if (errorMessage != null) {
                                    message = errorMessage
                                }
                            }

                            message
                        }
                    })
            } else {
                val fragment = fragmentManager.findFragmentByTag("SettingsFragment")
                val recyclerView = fragment.view.findViewById<RecyclerView>(R.id.list)
                val nameInput = recyclerView[0].input
                val currentPasswordInput = recyclerView[1].input

                if (nameInput.text.isBlank()) nameInput.error = getString(R.string.error_field_required)
                if (currentPasswordInput.text.isBlank()) currentPasswordInput.error = getString(R.string.error_field_required)
                if (settingsViewModel.isVegan && settingsViewModel.isVegetarian) toast(R.string.error_vegan_or_vegetarian)
            }
        }
    }

    override fun onDestroy() {
        if (this::disposable.isInitialized) disposable.dispose()
        settingsViewModel.clearPasswords()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (settingsViewModel.newValuesMap.isNotEmpty()) {
            buildBottomSheet(getString(R.string.message_unsaved_changes), getString(R.string.title_unsaved_changes)) {
                setNegativeText(R.string.action_dialog_leave)
                onNegative {
                    settingsViewModel.revertChanges()
                    finish()
                }
                setPositiveText(R.string.action_dialog_stay)
                setPositiveTextColor(R.color.black)
            }
        } else {
            super.onBackPressed()
        }
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return PreferenceFragment::class.java.name == fragmentName || SettingsFragment::class.java.name == fragmentName
    }
}
