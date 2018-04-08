package club.bweakfast.foodora.di.module

import android.content.Context
import club.bweakfast.foodora.BuildConfig
import club.bweakfast.foodora.StorageService
import club.bweakfast.foodora.auth.AuthenticationService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by silve on 3/2/2018.
 */

@Module
class FoodoraModule(private val context: Context) {
    @Provides
    fun provideRetrofit(storageService: StorageService): Retrofit {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
        if (storageService.hasToken()) {
            val clientBuilder = OkHttpClient.Builder()
            clientBuilder.addInterceptor {
                val originalRequest = it.request()
                @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                val requestBuilder = originalRequest
                    .newBuilder()
                    .addHeader("token", storageService.token)
                val request = requestBuilder.build()
                it.proceed(request)
            }
            val client = clientBuilder.build()
            retrofit.client(client)
        }
        return retrofit.build()
    }

    @Provides
    fun provideContext() = context
}