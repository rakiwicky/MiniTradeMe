package com.trademe.feature.home.internal.ui.main

import android.view.MenuItem
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trademe.feature.home.R
import com.trademe.feature.home.internal.HomeDestination.*
import com.trademe.feature.home.internal.ui.main.MainViewState.TargetState.*

internal class MainViewModel : ViewModel(), LifecycleObserver {

    private val viewState = MainViewState()
    val binding = viewState.binding

    val fragment = MutableLiveData<Class<*>>()

    init {
        viewState.moveTo(LatestListing)
        fragment.value = LATESTLISTING.fragmentClass
    }

    fun onBottomMenuClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_discover ->{
                viewState.moveTo(LatestListing)
                fragment.value = LATESTLISTING.fragmentClass
            }
            R.id.nav_notification ->{
                viewState.moveTo(Notification)
                fragment.value = NOTIFICATIONS.fragmentClass
            }
            R.id.nav_watchlist ->{
                viewState.moveTo(Watchlist)
                fragment.value = WATCHLIST.fragmentClass
            }
            R.id.nav_mytrademe ->{
                viewState.moveTo(MyTradeMe)
                fragment.value = MYTRADEME.fragmentClass
            }
        }
        return false
    }
}