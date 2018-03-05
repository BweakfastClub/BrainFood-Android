package club.bweakfast.foodora.auth

import club.bweakfast.foodora.network.ServerResponse
import com.google.gson.JsonObject
import io.reactivex.Single
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by silve on 3/4/2018.
 */

class AuthenticationService @Inject constructor(retrofit: Retrofit) {
    fun login(username: String, password: String): Single<Response<ServerResponse<JsonObject>>> =
        if (username == "banana" && password == "banana") {
            Single.just(Response.success(ServerResponse(JsonObject().apply {
                this.addProperty("error", false)
                this.addProperty("data", "User has successfully logged in")
            })))
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

    fun register(username: String, password: String): Single<Response<ServerResponse<JsonObject>>> =
        Single.just(Response.success(ServerResponse(JsonObject().apply {
            addProperty("error", false)
            addProperty("data", "User has successfully register")
        })))
}