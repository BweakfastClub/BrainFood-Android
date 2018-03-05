package club.bweakfast.foodora.user

import club.bweakfast.foodora.auth.AuthenticationService
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class UserViewModel @Inject constructor(private val service: AuthenticationService) {
    fun login(username: String, password: String) = service.login(username, password)

    fun register(username: String, password: String) = service.register(username, password)
}