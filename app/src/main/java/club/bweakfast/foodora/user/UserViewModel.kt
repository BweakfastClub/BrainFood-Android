package club.bweakfast.foodora.user

import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.network.mapResponse
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class UserViewModel @Inject constructor(private val service: AuthenticationService) {
    fun login(email: String, password: String): Completable {
        return service.login(email, password).mapResponse()
            .flatMapCompletable { (token) ->
                service.token = token
                Completable.complete()
            }
    }

    fun register(name: String, email: String, password: String): Completable {
        return service.register(name, email, password).mapResponse()
    }
}