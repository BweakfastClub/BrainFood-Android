package club.bweakfast.foodora.network

import android.util.Log
import club.bweakfast.foodora.BuildConfig
import io.reactivex.Completable
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

private val retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
private val converter = retrofit.responseBodyConverter<ErrorResponse>(
    ErrorResponse::class.java,
    arrayOfNulls(0)
)

fun parseError(errorBody: ResponseBody?): String? {
    return try {
        if (errorBody != null) {
            converter.convert(errorBody).error
        } else {
            null
        }
    } catch (e: IOException) {
        Log.e("NetworkUtil.parseError", "An error occurred", e)
        null
    }
}

fun <T> Single<Response<T>>.mapResponse(): Single<T> = flatMap {
    if (it.isSuccessful) {
        Single.just(it.body())
    } else {
        Single.error(HttpException(it))
    }
}

fun Single<Response<Void>>.mapResponse(): Completable = flatMapCompletable {
    if (it.isSuccessful) {
        Completable.complete()
    } else {
        Completable.error(HttpException(it))
    }
}
