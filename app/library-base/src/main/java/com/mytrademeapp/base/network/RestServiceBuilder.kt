package com.mytrademeapp.base.network

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit

class RestServiceBuilder(
    private val converterFactory: Converter.Factory,
    private val callAdapterFactory: CallAdapter.Factory
) {

    fun <T> create(kClass: Class<T>, _baseUrl: String, client: OkHttpClient): T {
        val baseUrl = if (_baseUrl.endsWith("/")) _baseUrl else "$_baseUrl/"

        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .build()
            .create(kClass)
    }
}