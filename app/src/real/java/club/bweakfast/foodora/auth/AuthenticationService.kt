package club.bweakfast.foodora.auth

import club.bweakfast.foodora.StorageService
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class AuthenticationService @Inject constructor(
    retrofit: Retrofit,
    storageService: StorageService
) {
    private val api: AuthenticationAPI = retrofit.create(AuthenticationAPI::class.java)
    val isLoggedIn = storageService.isLoggedIn

    fun login(email: String, password: String): Single<Response<LoginResponse>> {
        return api.login(mapOf("email" to email, "password" to password))
    }

    fun register(name: String, email: String, password: String): Single<Response<Void>> {
        return api.register(mapOf("name" to name, "email" to email, "password" to password))
    }

    interface AuthenticationAPI {
        @POST("/users/login")
        fun login(@Body loginJSON: Map<String, String>): Single<Response<LoginResponse>>

        @POST("/users")
        fun register(@Body registerJSON: Map<String, String>): Single<Response<Void>>
    }
}