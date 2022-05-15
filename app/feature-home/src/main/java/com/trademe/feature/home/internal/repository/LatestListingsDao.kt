package com.trademe.feature.home.internal.repository

import io.reactivex.Single
import retrofit2.http.GET

internal interface LatestListingsDao {

    @GET("v1/listings/latest.json")
    fun getLatestListings() : Single<LatestListingsDto>
}