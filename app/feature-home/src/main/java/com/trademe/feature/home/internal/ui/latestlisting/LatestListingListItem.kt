package com.trademe.feature.home.internal.ui.latestlisting

internal data class LatestListingListItem(
    val listingId: Long,
    val title: String?,
    val region: String?,
    val priceDisplay: String,
    val buyNowPrice: String?,
    val pictureHref: String?,
    val buyNowVisible: Boolean
)