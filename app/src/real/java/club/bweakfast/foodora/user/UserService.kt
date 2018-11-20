package club.bweakfast.foodora.user

import club.bweakfast.foodora.util.mapResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import javax.inject.Inject

open class UserService @Inject constructor(retrofit: Retrofit) {
    private val api = retrofit.create(UserAPI::class.java)

    fun addAllergies(allergies: List<String>) = api.addAllergies(mapOf("allergies" to allergies)).mapResponse()

    fun getUserInfo() = api.getUserInfo().mapResponse()

    fun updateUserInfo(userInfoJSON: Map<String, String>) = api.updateUserInfo(userInfoJSON).mapResponse()

    interface UserAPI {
        @POST("/users/allergies")
        fun addAllergies(@Body allergiesJSON: Map<String, @JvmSuppressWildcards List<String>>): Single<Response<Void>>

        @GET("/users/user_info")
        fun getUserInfo(): Single<Response<User>>

        @PUT("/users/user_info")
        fun updateUserInfo(@Body userInfoJSON: Map<String, String>): Single<Response<Void>>
    }
}