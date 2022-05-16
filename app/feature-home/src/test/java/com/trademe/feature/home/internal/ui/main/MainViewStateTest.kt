package com.trademe.feature.home.internal.ui.main

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mytrademeapp.base.test.applicationResources
import com.trademe.feature.home.internal.ui.main.MainViewState.TargetState.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewStateTest {

    private val viewState = MainViewState(applicationResources)

    @Test fun `verify - initial state`() {
        val sdf = java.text.SimpleDateFormat("yyyy-MM-dd")
        val date = java.util.Date(1652701471787)

        print(sdf.format(date))

        viewState.binding.value?.run {
            assertThat(title).isEqualTo("Browse")
        }
    }

    @Test fun `moveTo - latest listing - updates correctly`() {
        viewState.moveTo(LatestListing)

        viewState.binding.value?.run {
            assertThat(title).isEqualTo("Browse")
        }
    }

    @Test fun `moveTo - watchlist - updates correctly`() {
        viewState.moveTo(Watchlist)

        viewState.binding.value?.run {
            assertThat(title).isEqualTo("Watchlist")
        }
    }

    @Test fun `moveTo - notifications - updates correctly`() {
        viewState.moveTo(Notification)

        viewState.binding.value?.run {
            assertThat(title).isEqualTo("Notifications")
        }
    }

    @Test fun `moveTo - error - updates correctly`() {
        viewState.moveTo(MyTradeMe)

        viewState.binding.value?.run {
            assertThat(title).isEqualTo("My Trade Me")
        }
    }
}