package com.trademe.feature.home.internal.ui.latestlisting

internal data class LatestListingListItem(
    val listingId: Long,
    val title: String?,
    val region: String?,
    val startPrice: String,
    val buyNowPrice: Double?,
    val pictureHref: String?
)