package club.bweakfast.foodora.settings

import android.content.SharedPreferences
import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.user.UserService
import io.reactivex.Completable
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val userService: UserService,
    private val storageService: StorageService
) {
    val isSettingsValid: Boolean
        get() = isValid()

    private fun isValid(): Boolean {
        return name.isNullOrBlank().not() && currentPassword.isNullOrBlank().not()
    }

    val name: String?
        get() = storageService.name

    var currentPassword: String?
        get() = storageService.currentPassword
        private set(value) {
            storageService.currentPassword = value
        }

    var newPassword: String?
        get() = storageService.newPassword
        private set(value) {
            storageService.newPassword = value
        }

    private val isVegan: Boolean
        get() = storageService.isVegan

    private val isVegetarian: Boolean
        get() = storageService.isVegetarian

    private val hasPeanutAllergy: Boolean
        get() = storageService.hasPeanutAllergy

    val oldValuesMap = mapOf(
        "name" to name,
        "current_password" to currentPassword,
        "new_password" to newPassword,
        "is_vegan" to isVegan.toString(),
        "is_vegetarian" to isVegetarian.toString(),
        "has_peanut_allergy" to hasPeanutAllergy.toString()
    )

    val newValuesMap = mutableMapOf<String, String?>()

    val preferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
        newValuesMap[key] = when (key) {
            "name", "current_password", "new_password" -> prefs.getString(key, null)
            else -> prefs.getBoolean(key, false).toString()
        }
    }

    fun revertChanges() {
        newValuesMap.keys.forEach {
            storageService[it] = oldValuesMap[it]
        }
    }

    fun saveChanges(): Completable {
        val allergies = mutableListOf<String>()
        val userInfo = mutableMapOf<String, String>()

        newValuesMap.keys.forEach {
            when (it) {
                "is_vegan" -> allergies.add("Vegan")
                "is_vegetarian" -> allergies.add("Vegetarian")
                "has_peanut_allergy" -> allergies.add("Peanuts")
                "name" -> userInfo[it] = newValuesMap[it]!!
                "current_password" -> userInfo["password"] = newValuesMap[it]!!
                "new_password" -> userInfo["newPassword"] = newValuesMap[it]!!
            }
        }

        return Completable.merge(listOf(userService.updateUserInfo(userInfo), userService.addAllergies(allergies)))
    }

    fun clearPasswords() {
        newValuesMap.keys.filter { it.contains("password") }.forEach { storageService[it] = "" }
    }

    fun logout() {
        storageService.logout()
    }
}