package club.bweakfast.foodora.user

import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.network.mapResponse
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class UserViewModel @Inject constructor(private val service: AuthenticationService) {
    fun login(email: String, password: String) = service.login(email, password).mapResponse()

    fun register(email: String, password: String) =
        service.register(email, password).mapResponse()
}