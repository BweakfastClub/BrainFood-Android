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

    var currentPassword: String?
        get() = preferences.getString(currentPasswordKey, null)
        set(value) {
            preferences.edit().putString(currentPasswordKey, value).apply()
        }

    var newPassword: String?
        get() = preferences.getString(newPasswordKey, null)
        set(value) {
            preferences.edit().putString(newPasswordKey, value).apply()
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
        currentPasswordKey = context.getString(R.string.pref_key_password_current)
        newPasswordKey = context.getString(R.string.pref_key_password_new)
    }

    operator fun <V> set(key: String, value: V) {
        val editor = preferences.edit()
        when (key) {
            nameKey, currentPasswordKey, newPasswordKey -> editor.putString(key, value as String).apply()
            vegetarianKey, veganKey, peanutAllergyKey -> {
                if (value is String) {
                    editor.putBoolean(key, value.toBoolean())
                } else if (value is Boolean) {
                    editor.putBoolean(key, value)
                }
            }
        }
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
        private lateinit var currentPasswordKey: String
        private lateinit var newPasswordKey: String
    }
}