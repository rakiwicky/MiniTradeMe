package com.trademe.feature.home.internal.ui.watchlist

import android.content.res.Resources
import com.mytrademeapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class WatchlistViewModel @Inject constructor(
    resources: Resources
) : BaseViewModel() {

    private val viewState = WatchlistViewState(resources)
    val binding = viewState.binding
}