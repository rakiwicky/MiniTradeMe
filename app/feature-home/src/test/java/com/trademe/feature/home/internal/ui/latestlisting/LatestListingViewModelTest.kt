package com.trademe.feature.home.internal.ui.latestlisting

import androidx.lifecycle.LiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockito_kotlin.*
import com.trademe.feature.home.internal.domain.LatestListing
import com.trademe.feature.home.internal.repository.LatestListingsRepository
import com.trademe.feature.home.internal.ui.latestlisting.LatestListingViewState.TargetState.*
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class LatestListingViewModelTest {

    private val latestListingsListMapper = mock<LatestListingsListMapper>()
    private val latestListingsRepository = mock<LatestListingsRepository>()

    private val viewModel by lazy {
        LatestListingViewModel(
            latestListingsRepository,
            latestListingsListMapper,
            Schedulers.trampoline(),
            Schedulers.trampoline(),
            viewStateFactory
        )
    }

    private val binding = mock<LiveData<LatestListingViewStateBinding>> {
        on { value } doReturn mock<LatestListingViewStateBinding>()
    }

    private val viewState = mock<LatestListingViewState> {
        on { binding } doReturn binding
    }

    private val viewStateFactory = mock<LatestListingViewState.Factory> {
        on { create() } doAnswer {
            viewState
        }
    }

    @Test fun `loadLatestListings - no error - moves to loading state, calls getLatestListings, moves to content state`() {
        whenever(latestListingsRepository.getLatestListings()).thenReturn(Single.just(listOf(createLatestListing())))

        viewModel

        inOrder(viewState, latestListingsRepository) {
            verify(viewState).binding
            verify(viewState).moveTo(Loading)
            verify(latestListingsRepository).getLatestListings()
            verify(viewState).moveTo(Content(latestListingsListMapper.transform(listOf(createLatestListing()))))
        }
    }

    @Test fun `loadLatestListings - error - moves to error state`() {
        whenever(latestListingsRepository.getLatestListings()).thenReturn(Single.error(Exception()))

        viewModel

        inOrder(viewState) {
            verify(viewState).binding
            verify(viewState).moveTo(Error)
        }
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
}
