package club.bweakfast.foodora

import android.content.Context
import android.preference.PreferenceManager
import javax.inject.Inject

class StorageService @Inject constructor(context: Context) {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    var token: String?
        get() = preferences.getString(tokenKey, null)
        set(value) = saveToken(value!!)
    val isLoggedIn: Boolean
        get() = hasToken()

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

    companion object {
        private const val tokenKey = "auth"
    }
}