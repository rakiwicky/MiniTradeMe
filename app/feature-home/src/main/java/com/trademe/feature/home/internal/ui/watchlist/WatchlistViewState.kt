package com.trademe.feature.home.internal.ui.watchlist

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trademe.feature.home.R

internal class WatchlistViewState(
    resources: Resources
) {

    private val _binding = MutableLiveData(
        WatchlistViewStateBinding(
            title = resources.getString(R.string.home_watchlist_screen_title),
        )
    )

    val binding: LiveData<WatchlistViewStateBinding> = _binding
}