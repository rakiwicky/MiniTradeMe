package com.trademe.feature.home.internal.ui.main

import android.view.MenuItem
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trademe.feature.home.R
import com.trademe.feature.home.internal.HomeDestination.*
import com.trademe.feature.home.internal.ui.main.MainViewState.TargetState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    viewStateFactory: MainViewState.Factory
) : ViewModel(), LifecycleObserver {

    private val viewState = viewStateFactory.create()
    val binding = viewState.binding

    val fragment = MutableLiveData<Class<*>>()

    init {
        viewState.moveTo(LatestListing)
        fragment.value = LATESTLISTING.fragmentClass
    }

    fun onBottomMenuClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_discover ->{
                item.isChecked = true
                viewState.moveTo(LatestListing)
                fragment.value = LATESTLISTING.fragmentClass
            }
            R.id.nav_notification ->{
                item.isChecked = true
                viewState.moveTo(Notification)
                fragment.value = NOTIFICATIONS.fragmentClass
            }
            R.id.nav_watchlist ->{
                item.isChecked = true
                viewState.moveTo(Watchlist)
                fragment.value = WATCHLIST.fragmentClass
            }
            R.id.nav_mytrademe ->{
                item.isChecked = true
                viewState.moveTo(MyTradeMe)
                fragment.value = MYTRADEME.fragmentClass
            }
        }
        return false
    }
}