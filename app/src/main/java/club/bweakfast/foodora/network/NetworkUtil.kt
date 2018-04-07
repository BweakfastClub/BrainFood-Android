package club.bweakfast.foodora.network

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.HttpException
import retrofit2.Response

/**
 * Created by silver_android on 1/5/2017.
 */

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
