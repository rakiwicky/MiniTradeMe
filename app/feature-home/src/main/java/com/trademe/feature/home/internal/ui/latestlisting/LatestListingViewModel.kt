package com.trademe.feature.home.internal.ui.latestlisting

import android.content.res.Resources
import com.mytrademeapp.base.BaseViewModel
import com.mytrademeapp.base.network.applySchedulers
import com.mytrademeapp.base.network.plusAssign
import com.trademe.feature.home.internal.repository.LatestListingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import com.trademe.feature.home.internal.ui.latestlisting.LatestListingViewState.TargetState.*
import javax.inject.Inject

@HiltViewModel
internal class LatestListingViewModel @Inject constructor(
    resources: Resources,
    private val latestListingsRepository: LatestListingsRepository,
    private val latestListingsListMapper: LatestListingsListMapper
) : BaseViewModel() {

    private val viewState = LatestListingViewState(resources)
    val binding = viewState.binding

    init {
        loadDiscoverItems()
    }

    private fun loadDiscoverItems() {
        viewState.moveTo(Loading)
        disposable += latestListingsRepository.getLatestListings()
                .applySchedulers()
                .subscribe(::loadLatestListingsSuccess, ::loadLatestListingsFail)
    }

    private fun loadLatestListingsSuccess(latestListings: List<com.trademe.feature.home.internal.domain.LatestListing>) {
        viewState.moveTo(
            Content(
                latestListingsListMapper.transform(
                    latestListings
                )
            )
        )
    }

    private fun loadLatestListingsFail(error: Throwable) {
        viewState.moveTo(Error)
    }

    fun itemSelected(listItem: LatestListingListItem) {

    }
}