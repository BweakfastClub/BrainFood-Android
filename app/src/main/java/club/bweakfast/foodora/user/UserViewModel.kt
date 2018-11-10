package club.bweakfast.foodora.user

import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.auth.AuthenticationService
import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class UserViewModel @Inject constructor(
    private val authService: AuthenticationService,
    private val storageService: StorageService
) {
    val isLoggedIn = authService.isLoggedIn

    fun login(email: String, password: String): Completable {
        return authService.login(email, password)
            .flatMapCompletable { (token) ->
                storageService.token = token
                Completable.complete()
            }
    }

    fun register(name: String, email: String, password: String): Completable {
        return authService.register(name, email, password)
            .flatMapCompletable { (token) ->
                storageService.token = token
                Completable.complete()
            }
    }
}