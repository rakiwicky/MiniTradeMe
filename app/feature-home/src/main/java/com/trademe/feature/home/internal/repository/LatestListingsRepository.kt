package com.trademe.feature.home.internal.repository

import com.trademe.feature.home.internal.domain.LatestListing
import io.reactivex.Single

internal interface LatestListingsRepository {
    fun getLatestListings(): Single<List<LatestListing>>
}