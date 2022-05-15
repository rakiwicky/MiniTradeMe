package com.trademe.feature.home.internal.repository

import com.google.gson.annotations.SerializedName
import com.trademe.feature.home.internal.domain.LatestListing

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

        @SerializedName("PictureHref")
        val pictureHref: String?
    ) {
        fun toLatestListing(): LatestListing {
            return com.trademe.feature.home.internal.domain.LatestListing(
                listingId = listingId,
                title = title ?: "",
                region = region,
                startPrice = startPrice,
                buyNowPrice = buyNowPrice,
                pictureHref = pictureHref
            )
        }
    }

    fun toLatestListings(): List<LatestListing> {
        return list?.map(LatestListingDto::toLatestListing) ?: listOf()
    }
}