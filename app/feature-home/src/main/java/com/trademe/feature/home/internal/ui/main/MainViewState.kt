package com.trademe.feature.home.internal.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trademe.feature.home.internal.ui.main.MainViewState.TargetState.*

internal class MainViewState {
    private val _binding = MutableLiveData(
        MainViewStateBinding(
            title = "Browse"
        )
    )

    val binding: LiveData<MainViewStateBinding> = _binding

    fun moveTo(targetState: TargetState) {
        val currentState = _binding.value

        _binding.value = when (targetState) {
            is LatestListing -> {
                currentState!!.copy(title = "Browse")
            }
            is Watchlist -> {
                currentState!!.copy(title = "Watchlist")
            }
            is Notification -> {
                currentState!!.copy(title = "Notifications")
            }
            is MyTradeMe -> {
                currentState!!.copy(title = "My Trade Me")
            }
        }
    }

    sealed class TargetState {
        object LatestListing : TargetState()
        object Watchlist : TargetState()
        object Notification : TargetState()
        object MyTradeMe : TargetState()
    }
}