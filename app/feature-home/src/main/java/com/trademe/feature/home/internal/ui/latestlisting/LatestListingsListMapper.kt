package com.trademe.feature.home.internal.ui.latestlisting

import com.trademe.feature.home.internal.domain.LatestListing
import java.text.DecimalFormat

internal class LatestListingsListMapper {

    fun transform(latestListings: List<LatestListing>): List<LatestListingListItem> {
        return latestListings.map { createListItem(it) }
    }

    private fun createListItem(latestListing: LatestListing): LatestListingListItem {
        return LatestListingListItem(
            listingId = latestListing.listingId,
            title = latestListing.title,
            region = latestListing.title,
            startPrice = latestListing.startPrice.convert(),
            buyNowPrice = latestListing.buyNowPrice,
            pictureHref = latestListing.pictureHref
        )
    }

    fun Double.convert(): String {
        val format = DecimalFormat("#,###.00")
        format.isDecimalSeparatorAlwaysShown = false
        return format.format(this).toString()
    }
}