package club.bweakfast.foodora.settings

import android.content.SharedPreferences
import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.user.UserService
import club.bweakfast.foodora.util.log
import io.reactivex.Completable
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val userService: UserService,
    private val storageService: StorageService
) {
    val isSettingsValid: Boolean
        get() = isValid()

    private fun isValid(): Boolean {
        return name.isNullOrBlank().not() && currentPassword.isNullOrBlank().not() && (isVegan && isVegetarian).not()
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

    val isVegan: Boolean
        get() = storageService.isVegan

    val isVegetarian: Boolean
        get() = storageService.isVegetarian

    private val hasPeanutAllergy: Boolean
        get() = storageService.hasPeanutAllergy

    val oldValuesMap = mapOf(
        "name" to name,
        "current_password" to currentPassword,
        "new_password" to newPassword,
        "is_vegan" to isVegan,
        "is_vegetarian" to isVegetarian,
        "has_peanut_allergy" to hasPeanutAllergy
    )

    val newValuesMap = mutableMapOf<String, Any?>()

    val preferenceChangeListener = SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
        when (key) {
            "name", "current_password", "new_password" -> newValuesMap[key] = prefs.getString(key, null)
            "is_vegan", "is_vegetarian", "has_peanut_allergy" -> newValuesMap[key] = prefs.getBoolean(key, false)
        }
    }

    fun revertChanges() {
        newValuesMap.keys.forEach { key ->
            when (key) {
                "name", "current_password", "new_password" -> storageService[key] = oldValuesMap[key]
                "is_vegan", "is_vegetarian", "has_peanut_allergy" -> storageService[key] = oldValuesMap[key]
            }
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
                "name" -> userInfo[it] = newValuesMap[it]!! as String
                "current_password" -> userInfo["password"] = newValuesMap[it]!! as String
                "new_password" -> userInfo["newPassword"] = newValuesMap[it]!! as String
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