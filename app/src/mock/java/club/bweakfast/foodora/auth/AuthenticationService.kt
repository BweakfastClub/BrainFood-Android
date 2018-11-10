package club.bweakfast.foodora.auth

import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by silve on 3/4/2018.
 */

class AuthenticationService @Inject constructor() {
    var token: String? = "keyboardcat"
    val isLoggedIn = false

    fun login(email: String, password: String): Single<TokenResponse> {
        return if ((email == "banana" || email == "banana@apple.ca") && password == "banana") {
            Single
                .just(Response.success(TokenResponse(token!!)))
                .delay(2, TimeUnit.SECONDS)
        } else {
            Single.just(
                Response.error(
                    401,
                    ResponseBody.create(
                        MediaType.parse("application/json"),
                        "{ \"error\": false, \"data\": \"User and password has incorrect combination\" }"
                    )
                )
            )
        }
            .mapResponse()
    }

    fun register(name: String, email: String, password: String): Single<TokenResponse> {
        return Single.just(Response.success(TokenResponse(token!!))).mapResponse()
    }
}