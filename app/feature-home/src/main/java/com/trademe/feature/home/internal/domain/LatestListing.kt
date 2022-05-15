package com.trademe.feature.home.internal.domain

internal data class LatestListing (
    val listingId: Long,
    val title: String?,
    val region: String?,
    val startPrice: Double,
    val buyNowPrice: Double?,
    val pictureHref: String?
)