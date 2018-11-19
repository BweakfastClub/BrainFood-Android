package club.bweakfast.foodora.auth

import android.support.annotation.VisibleForTesting
import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.di.RetrofitContainer
import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

open class AuthenticationService @Inject constructor(retrofitContainer: RetrofitContainer, storageService: StorageService) {
    @VisibleForTesting
    open val api: AuthenticationAPI = retrofitContainer.retrofit.create(AuthenticationAPI::class.java)
    open val isLoggedIn = storageService.isLoggedIn

    fun login(email: String, password: String): Single<TokenResponse> {
        return api.login(mapOf("email" to email, "password" to password)).mapResponse()
    }

    fun register(name: String, email: String, password: String): Single<TokenResponse> {
        return api.register(mapOf("name" to name, "email" to email, "password" to password)).mapResponse()
    }

    interface AuthenticationAPI {
        @POST("/users/login")
        fun login(@Body loginJSON: Map<String, String>): Single<Response<TokenResponse>>

        @POST("/users")
        fun register(@Body registerJSON: Map<String, String>): Single<Response<TokenResponse>>
    }
}