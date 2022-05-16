package com.trademe.feature.home.internal.ui.latestlisting

import com.trademe.feature.home.internal.domain.LatestListing
import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

internal class LatestListingsListMapper {

    fun transform(latestListings: List<LatestListing>): List<LatestListingListItem> {
        return latestListings.map { createListItem(it) }.take(20)
    }

    private fun createListItem(latestListing: LatestListing): LatestListingListItem {
        return LatestListingListItem(
            listingId = latestListing.listingId,
            title = latestListing.title,
            region = latestListing.region,
            priceDisplay = latestListing.priceDisplay,
            buyNowPrice = getBuyNowPrice(latestListing.buyNowPrice),
            buyNowVisible = latestListing.buyNowPrice != null,
            pictureHref = latestListing.pictureHref
        )
    }

    private fun getBuyNowPrice(price: Double?): String{
        price?.let {
            val format: NumberFormat = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 2
            format.currency = Currency.getInstance("NZD")

            return format.format(it)
        }
        return ""
    }
}