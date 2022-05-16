package com.trademe.feature.home.internal.ui.watchlist

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import com.mytrademeapp.base.test.applicationResources

@RunWith(AndroidJUnit4::class)
class WatchlistViewStateTest {

    private val viewState = WatchlistViewState(applicationResources)

    @Test fun `verify - initial state`() {
        viewState.binding.value?.run {
            assertThat(title).isEqualTo("Watchlist")
        }
    }
}