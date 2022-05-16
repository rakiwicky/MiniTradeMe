package com.trademe.feature.home.internal.ui.main

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockito_kotlin.*
import com.trademe.feature.home.R
import com.trademe.feature.home.internal.HomeDestination
import com.trademe.feature.home.internal.HomeDestination.LATESTLISTING
import com.trademe.feature.home.internal.ui.main.MainViewState.TargetState.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.fakes.RoboMenuItem


@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    private val viewModel by lazy {
        MainViewModel(
            viewStateFactory
        )
    }

    private val binding = mock<LiveData<MainViewStateBinding>> {
        on { value } doReturn mock<MainViewStateBinding>()
    }

    private val viewState = mock<MainViewState> {
        on { binding } doReturn binding
    }

    private val viewStateFactory = mock<MainViewState.Factory> {
        on { create() } doAnswer {
            viewState
        }
    }

    @Test fun `verifies - default instance`() {
        viewModel

        inOrder(viewState) {
            verify(viewState).binding
            verify(viewState).moveTo(LatestListing)
        }

        viewModel.fragment.value.run {
            equals(LATESTLISTING.fragmentClass)
        }
    }

    @Test fun `onBottomMenuClicked - notification - shows correct screen`() {
        val item: MenuItem = RoboMenuItem(R.id.nav_notification)

        viewModel.run {
            onBottomMenuClicked(item)
        }

        inOrder(viewState) {
            verify(viewState).binding
            verify(viewState).moveTo(Notification)
        }

        viewModel.fragment.value.run {
            equals(HomeDestination.NOTIFICATIONS.fragmentClass)
        }
    }

    @Test fun `onBottomMenuClicked - watchlist - shows correct screen`() {
        val item: MenuItem = RoboMenuItem(R.id.nav_watchlist)

        viewModel.run {
            onBottomMenuClicked(item)
        }

        inOrder(viewState) {
            verify(viewState).binding
            verify(viewState).moveTo(Watchlist)
        }

        viewModel.fragment.value.run {
            equals(HomeDestination.WATCHLIST.fragmentClass)
        }
    }

    @Test fun `onBottomMenuClicked - my trade me - shows correct screen`() {
        val item: MenuItem = RoboMenuItem(R.id.nav_mytrademe)

        viewModel.run {
            onBottomMenuClicked(item)
        }

        inOrder(viewState) {
            verify(viewState).binding
            verify(viewState).moveTo(MyTradeMe)
        }

        viewModel.fragment.value.run {
            equals(HomeDestination.MYTRADEME.fragmentClass)
        }
    }
}