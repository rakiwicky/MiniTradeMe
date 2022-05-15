package com.trademe.feature.home.internal.ui.watchlist

import android.os.Bundle
import com.mytrademeapp.base.BaseViewModelFragment
import com.trademe.feature.home.R
import com.trademe.feature.home.databinding.HomeWatchlistFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class WatchlistFragment : BaseViewModelFragment<WatchlistViewModel, HomeWatchlistFragmentBinding>(
    WatchlistViewModel::class.java) {

    override val layoutId = R.layout.home_watchlist_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ui.viewModel = viewModel
    }
}