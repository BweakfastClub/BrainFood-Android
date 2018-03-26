package club.bweakfast.foodora.network

import io.reactivex.Single
import retrofit2.HttpException
import retrofit2.Response

/**
 * Created by silver_android on 1/5/2017.
 */

fun <T> Single<Response<T>>.mapResponse(): Single<T> = flatMap {
    if (!it.isSuccessful) {
        Single.error(HttpException(it))
    } else {
        Single.just(it.body())
    }
}
