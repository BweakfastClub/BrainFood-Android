package club.bweakfast.foodora

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StorageService @Inject constructor(context: Context) {
    var token: String? = null
    val isLoggedIn: Boolean
        get() = hasToken()

    var isSetupComplete: Boolean = true

    var name: String? = "Rushil"

    val isVegan: Boolean = false

    val isVegetarian: Boolean = false

    val hasPeanutAllergy: Boolean = false

    init {
        nameKey = context.getString(R.string.pref_key_name)
        veganKey = context.getString(R.string.pref_key_is_vegan)
        vegetarianKey = context.getString(R.string.pref_key_is_vegetarian)
        peanutAllergyKey = context.getString(R.string.pref_key_has_peanut_allergy)
    }

    fun logout() {
        deleteToken()
    }

    fun hasToken() = token != null

    private fun deleteToken() {
        token = null
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