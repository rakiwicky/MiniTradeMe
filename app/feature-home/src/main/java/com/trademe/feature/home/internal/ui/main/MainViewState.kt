package com.trademe.feature.home.internal.ui.main

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trademe.feature.home.R
import com.trademe.feature.home.internal.ui.main.MainViewState.TargetState.*
import javax.inject.Inject

internal class MainViewState(
    private val resources: Resources
) {
    private val _binding = MutableLiveData(
        MainViewStateBinding(
            title = resources.getString(R.string.home_title_browse)
        )
    )

    val binding: LiveData<MainViewStateBinding> = _binding

    fun moveTo(targetState: TargetState) {
        val currentState = _binding.value

        _binding.value = when (targetState) {
            is LatestListing -> {
                currentState!!.copy(title = resources.getString(R.string.home_title_browse))
            }
            is Watchlist -> {
                currentState!!.copy(title = resources.getString(R.string.home_title_watchlist))
            }
            is Notification -> {
                currentState!!.copy(title = resources.getString(R.string.home_title_notifications))
            }
            is MyTradeMe -> {
                currentState!!.copy(title = resources.getString(R.string.home_title_mytrade_me))
            }
        }
    }

    class Factory @Inject constructor(private val resources: Resources) {
        fun create(
        ) = MainViewState(resources)
    }

    sealed class TargetState {
        object LatestListing : TargetState()
        object Watchlist : TargetState()
        object Notification : TargetState()
        object MyTradeMe : TargetState()
    }
}