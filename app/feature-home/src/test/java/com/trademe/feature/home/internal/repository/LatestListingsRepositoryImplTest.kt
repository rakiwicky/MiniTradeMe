package com.trademe.feature.home.internal.repository

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.trademe.feature.home.internal.domain.LatestListing
import io.reactivex.Single
import org.junit.Test

class LatestListingsRepositoryImplTest {

    private val latestListingsDao = mock<LatestListingsDao>()
    private val repository = LatestListingsRepositoryImpl(latestListingsDao)

    @Test fun `getLatestListings - verifies correct dto emitted`() {
        whenever(latestListingsDao.getLatestListings()).thenReturn(
            Single.just(
                createLatestListingDto()
            )
        )

        repository.getLatestListings().test().assertValue(createLatestListingList())
        verify(latestListingsDao).getLatestListings()
    }

    private fun createLatestListingList(): List<LatestListing> {
        return listOf(
            LatestListing(
                listingId = 10002,
                title = "Chicken run2",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$45.00"
            ),
            LatestListing(
                listingId = 10003,
                title = "Chicken run3",
                region = "Auckland",
                startPrice = 25.000,
                buyNowPrice = 35.000,
                pictureHref = "",
                hasBuyNow = true,
                isClassified = false,
                startDate = "/Date(1514764800)\\/",
                priceDisplay = "$55.00"
            )
        )
    }

    private fun createLatestListingDto(): LatestListingsDto {
        return LatestListingsDto(
            listOf(
                LatestListingsDto.LatestListingDto(
                    listingId = 10002,
                    title = "Chicken run2",
                    region = "Auckland",
                    startPrice = 25.000,
                    buyNowPrice = 35.000,
                    pictureHref = "",
                    hasBuyNow = true,
                    isClassified = false,
                    startDate = "/Date(1514764800)\\/",
                    priceDisplay = "$45.00"
                ),
                LatestListingsDto.LatestListingDto(
                    listingId = 10003,
                    title = "Chicken run3",
                    region = "Auckland",
                    startPrice = 25.000,
                    buyNowPrice = 35.000,
                    pictureHref = "",
                    hasBuyNow = true,
                    isClassified = false,
                    startDate = "/Date(1514764800)\\/",
                    priceDisplay = "$55.00"
                )
            )
        )
    }
}