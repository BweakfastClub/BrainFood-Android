package club.bweakfast.foodora.auth

import android.content.Context
import android.preference.PreferenceManager
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class AuthenticationService @Inject constructor(retrofit: Retrofit, context: Context) {
    private val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val api: AuthenticationAPI = retrofit.create(AuthenticationAPI::class.java)
    var token: String?
        get() = preferences.getString(tokenKey, null)
        set(value) = saveToken(value!!)
    val isLoggedIn: Boolean
        get() = hasToken()

    fun login(email: String, password: String): Single<Response<LoginResponse>> {
        return api.login(mapOf("email" to email, "password" to password))
    }

    fun register(name: String, email: String, password: String): Single<Response<Void>> {
        return api.register(mapOf("name" to name, "email" to email, "password" to password))
    }

    fun logout() {
        deleteToken()
    }

    private fun hasToken() = preferences.contains(tokenKey)

    private fun saveToken(token: String) {
        preferences.edit().putString(tokenKey, token).apply()
    }

    private fun deleteToken() {
        preferences.edit().remove(tokenKey).apply()
    }

    interface AuthenticationAPI {
        @POST("/users/login")
        fun login(@Body loginJSON: Map<String, String>): Single<Response<LoginResponse>>

        @POST("/users")
        fun register(@Body registerJSON: Map<String, String>): Single<Response<Void>>
    }

    companion object {
        private val tokenKey = "auth"
    }
}