package com.trademe.feature.home.internal.ui.latestlisting

import com.mytrademeapp.base.BaseViewModel
import com.mytrademeapp.base.network.plusAssign
import com.trademe.feature.home.internal.repository.LatestListingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import com.trademe.feature.home.internal.ui.latestlisting.LatestListingViewState.TargetState.*
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
internal class LatestListingViewModel @Inject constructor(
    private val latestListingsRepository: LatestListingsRepository,
    private val latestListingsListMapper: LatestListingsListMapper,
    @Named("AndroidSchedulers") private val androidSchedulers: Scheduler,
    @Named("IOSchedulers") private val scheduler: Scheduler,
    viewStateFactory: LatestListingViewState.Factory
) : BaseViewModel() {

    private val viewState = viewStateFactory.create()
    val binding = viewState.binding

    init {
        loadLatestListings()
    }

    private fun loadLatestListings() {
        viewState.moveTo(Loading)
        disposable += latestListingsRepository.getLatestListings()
            .observeOn(androidSchedulers)
            .subscribeOn(scheduler)
            .subscribe(::loadLatestListingsSuccess, ::loadLatestListingsFail)
    }

    private fun loadLatestListingsSuccess(latestListings: List<com.trademe.feature.home.internal.domain.LatestListing>) {
        viewState.moveTo(Content(latestListingsListMapper.transform(latestListings)))
    }

    private fun loadLatestListingsFail(error: Throwable) {
        viewState.moveTo(Error)
    }

    fun itemSelected(listItem: LatestListingListItem) {

    }
}