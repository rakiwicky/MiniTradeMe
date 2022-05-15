package com.trademe.feature.home.internal.repository

import com.trademe.feature.home.internal.domain.LatestListing
import io.reactivex.Single
import javax.inject.Inject

internal class LatestListingsRepositoryImpl @Inject constructor(
    private val latestListingsDao: LatestListingsDao
) : LatestListingsRepository {

    override fun getLatestListings(): Single<List<LatestListing>> {
        return latestListingsDao.getLatestListings().map(LatestListingsDto::toLatestListings)
    }
}