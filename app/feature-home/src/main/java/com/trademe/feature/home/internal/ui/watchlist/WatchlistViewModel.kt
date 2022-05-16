package com.trademe.feature.home.internal.ui.watchlist

import com.mytrademeapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class WatchlistViewModel @Inject constructor(
    viewStateFactory: WatchlistViewState.Factory
) : BaseViewModel() {

    private val viewState = viewStateFactory.create()
    val binding = viewState.binding
}