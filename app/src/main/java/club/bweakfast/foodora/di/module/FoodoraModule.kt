package club.bweakfast.foodora.di.module

import club.bweakfast.foodora.BuildConfig
import club.bweakfast.foodora.auth.AuthenticationService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by silve on 3/2/2018.
 */

@Module
class FoodoraModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
        return retrofit.build()
    }

    @Provides
    fun provideAuthService(retrofit: Retrofit) = AuthenticationService(retrofit)
}