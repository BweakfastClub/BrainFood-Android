package rbsoftware.friendstagram.service

import android.util.Log
import club.bweakfast.foodora.network.ErrorResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * Created by silver_android on 1/5/2017.
 */

object NetworkService {
    private val TAG = "NetworkService"

    fun parseError(errorBody: ResponseBody?): String? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://httpbin.org")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val converter = retrofit.responseBodyConverter<ErrorResponse>(
            ErrorResponse::class.java,
            arrayOfNulls(0)
        )

        return try {
            if (errorBody != null) {
                return converter.convert(errorBody).data
            } else {
                null
            }
        } catch (e: IOException) {
            Log.e(TAG, "An error occurred", e)
            null
        }
    }
}

fun <T> Single<Response<T>>.mapResponse(): Single<T> = flatMap {
    if (!it.isSuccessful) {
        Single.error(HttpException(it))
    } else {
        Single.just(it.body())
    }
}
