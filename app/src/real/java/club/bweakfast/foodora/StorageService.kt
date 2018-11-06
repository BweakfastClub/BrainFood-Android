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

    var name: String?
        get() = preferences.getString(nameKey, null)
        set(value) {
            saveName(value!!)
        }

    init {
        nameKey = context.getString(R.string.pref_key_name)
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
        private lateinit var nameKey: String
    }
}