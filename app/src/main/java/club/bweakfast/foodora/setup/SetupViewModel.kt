package club.bweakfast.foodora.setup

import club.bweakfast.foodora.StorageService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetupViewModel @Inject constructor(private val storageService: StorageService) {
    val isStep1Valid: Boolean
        get() = validateStep1()

    var isStep2Valid: Boolean = false

    private fun validateStep1(): Boolean {
        val name = storageService.name
        return !name.isNullOrBlank()
    }
}