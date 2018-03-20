package club.bweakfast.foodora.auth

import club.bweakfast.foodora.network.ServerResponse
import com.google.gson.JsonObject
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by silve on 3/2/2018.
 */

class AuthenticationService @Inject constructor(retrofit: Retrofit) {
    private val api: AuthenticationAPI = retrofit.create(AuthenticationAPI::class.java)

    fun login(email: String, password: String) = api.login(email, password)

    fun register(email: String, password: String) = api.register(email, password)

    interface AuthenticationAPI {
        @GET("/get")
        fun login(@Query("email") email: String, @Query("password") password: String): Single<Response<ServerResponse<JsonObject>>>

        @GET("/ip")
        fun register(@Query("email") email: String, @Query("password") password: String): Single<Response<ServerResponse<JsonObject>>>
    }
}