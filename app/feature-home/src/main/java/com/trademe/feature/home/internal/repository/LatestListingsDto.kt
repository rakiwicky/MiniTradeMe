package com.trademe.feature.home.internal.repository

import com.google.gson.annotations.SerializedName
import com.trademe.feature.home.internal.domain.LatestListing
import kotlinx.coroutines.processNextEventInCurrentThread
import java.time.LocalDateTime
import java.util.*

internal data class LatestListingsDto(
    @SerializedName("List") private val list: List<LatestListingDto>?
) {
    data class LatestListingDto(
        @SerializedName("ListingId")
        val listingId: Long,

        @SerializedName("Title")
        val title: String?,

        @SerializedName("Region")
        val region: String?,

        @SerializedName("StartPrice")
        val startPrice: Double,

        @SerializedName("BuyNowPrice")
        val buyNowPrice: Double?,

        @SerializedName("HasBuyNow")
        val hasBuyNow: Boolean,

        @SerializedName("PictureHref")
        val pictureHref: String?,

        @SerializedName("IsClassified")
        val isClassified: Boolean,

        @SerializedName("StartDate")
        val startDate: String,

        @SerializedName("PriceDisplay")
        val priceDisplay: String
    ) {
        fun toLatestListing(): LatestListing {
            return LatestListing(
                listingId = listingId,
                title = title,
                region = region,
                startPrice = startPrice,
                buyNowPrice = buyNowPrice,
                hasBuyNow = hasBuyNow,
                pictureHref = pictureHref,
                isClassified = isClassified,
                startDate = startDate,
                priceDisplay = priceDisplay
            )
        }
    }

    fun toLatestListings(): List<LatestListing> {
        return list?.map(LatestListingDto::toLatestListing) ?: listOf()
    }
}