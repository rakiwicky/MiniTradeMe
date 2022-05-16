package com.mytrademeapp.base.di

import com.mytrademeapp.base.network.RestServiceBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer
import se.akerfeldt.okhttp.signpost.SigningInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun restServiceBuilder(): RestServiceBuilder {
        return RestServiceBuilder(
            GsonConverterFactory.create(),
            RxJava2CallAdapterFactory.create()
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val consumer = OkHttpOAuthConsumer(
            "A1AC63F0332A131A78FAC304D007E7D1",
            "EC7F18B17A062962C6930A8AE88B16C7"
        )

        return OkHttpClient.Builder()
            .addInterceptor(SigningInterceptor(consumer))
            .build()
    }

    @Provides
    @Named("TradeMe_BaseURL")
    @Singleton
    fun provideTradeMeBaseUrl(): String {
        return "https://api.tmsandbox.co.nz/"
    }

    @Provides
    @Singleton
    @Named("AndroidSchedulers")
    fun provideAndroidSchedulers(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    @Named("IOSchedulers")
    fun provideSchedulers(): Scheduler {
        return Schedulers.io()
    }
}