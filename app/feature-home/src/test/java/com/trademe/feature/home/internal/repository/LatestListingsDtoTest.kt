package com.trademe.feature.home.internal.repository

import com.google.common.truth.Truth.assertThat
import com.trademe.feature.home.internal.domain.LatestListing
import com.trademe.feature.home.internal.repository.LatestListingsDto.LatestListingDto
import org.junit.Test

class LatestListingsDtoTest {

    @Test fun `toLatestListing - verify domain mapping`() {
        assertThat(LatestListingsDto(createLatestListingDtoList()).toLatestListings())
            .isEqualTo(createLatestListingList())
    }

    @Test fun `toLatestListing - with no latest listings - returns empty latest listing list`() {
        assertThat(LatestListingsDto(emptyList()).toLatestListings())
            .isEqualTo(listOf<LatestListing>())
    }

    private fun createLatestListingList(): List<LatestListing> {
        return listOf(
            createLatestListing(
                listingId = 10000,
                title = "Chicken run1",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$60.00"
            ),
            createLatestListing(
                listingId = 10001,
                title = "Chicken run2",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$50.00"
            ),
            createLatestListing(
                listingId = 10002,
                title = "Chicken run3",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$45.00"
            )
        )
    }

    private fun createLatestListing(
        listingId: Long = 10000,
        title: String? = "Chicken run",
        region: String? = "Auckland",
        startPrice: Double = 25.000,
        buyNowPrice: Double? = 35.000,
        pictureHref: String? = "",
        hasBuyNow: Boolean = true,
        isClassified: Boolean = false,
        startDate: String = "/Date(1514764800)\\/",
        priceDisplay: String = "$45.00"
    ): LatestListing {
        return LatestListing(
            listingId,
            title,
            region,
            startPrice,
            buyNowPrice,
            pictureHref,
            hasBuyNow,
            isClassified,
            startDate,
            priceDisplay
        )
    }

    private fun createLatestListingDtoList(): List<LatestListingDto> {
        return listOf(
            createLatestListingDto(
                listingId = 10000,
                title = "Chicken run1",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$60.00"
            ),
            createLatestListingDto(
                listingId = 10001,
                title = "Chicken run2",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$50.00"
            ),
            createLatestListingDto(
                listingId = 10002,
                title = "Chicken run3",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$45.00"
            )
        )
    }

    private fun createLatestListingDto(
        listingId: Long = 10000,
        title: String? = "Chicken run",
        region: String? = "Auckland",
        startPrice: Double = 25.000,
        buyNowPrice: Double? = 35.000,
        pictureHref: String? = "",
        hasBuyNow: Boolean = true,
        isClassified: Boolean = false,
        startDate: String = "/Date(1514764800)\\/",
        priceDisplay: String = "$45.00"
    ): LatestListingDto {
        return LatestListingDto(
            listingId,
            title,
            region,
            startPrice,
            buyNowPrice,
            hasBuyNow,
            pictureHref,
            isClassified,
            startDate,
            priceDisplay
        )
    }
}