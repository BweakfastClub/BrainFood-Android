package club.bweakfast.foodora

import android.content.Context
import android.preference.PreferenceManager
import javax.inject.Inject

class StorageService @Inject constructor(private val context: Context) {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    var token: String?
        get() = preferences.getString(tokenKey, null)
        set(value) {
            saveToken(value!!)
        }
    val isLoggedIn: Boolean
        get() = hasToken()

    var isSetupComplete: Boolean
        get() = preferences.getBoolean(setupCompleteKey, true)
        set(value) {
            preferences.edit().putBoolean(setupCompleteKey, value).apply()
        }

    var name: String?
        get() = preferences.getString(nameKey, null)
        set(value) {
            saveName(value!!)
        }

    val isVegan: Boolean
        get() = preferences.getBoolean(veganKey, false)

    val isVegetarian: Boolean
        get() = preferences.getBoolean(vegetarianKey, false)

    val hasPeanutAllergy: Boolean
        get() = preferences.getBoolean(peanutAllergyKey, false)

    init {
        nameKey = context.getString(R.string.pref_key_name)
        veganKey = context.getString(R.string.pref_key_is_vegan)
        vegetarianKey = context.getString(R.string.pref_key_is_vegetarian)
        peanutAllergyKey = context.getString(R.string.pref_key_has_peanut_allergy)
    }

    fun logout() {
        deleteToken()
    }

    fun hasToken() = preferences.contains(tokenKey)

    private fun saveToken(token: String) {
        preferences.edit().putString(tokenKey, token).apply()
    }

    private fun deleteToken() {
        preferences.edit().remove(tokenKey).apply()
    }

    private fun saveName(name: String) {
        preferences.edit().putString(nameKey, name).apply()
    }

    companion object {
        private const val tokenKey = "auth"
        private const val setupCompleteKey = "setup_complete"
        private lateinit var nameKey: String
        private lateinit var veganKey: String
        private lateinit var vegetarianKey: String
        private lateinit var peanutAllergyKey: String
    }
}