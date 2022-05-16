package com.trademe.feature.home.internal.ui.latestlisting

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import com.mytrademeapp.base.test.applicationResources
import com.trademe.feature.home.internal.ui.latestlisting.LatestListingViewState.TargetState.*

@RunWith(AndroidJUnit4::class)
class LatestListingViewStateTest {

    private val viewState = LatestListingViewState(applicationResources)

    @Test fun `verify - initial state`() {
        viewState.binding.value?.run {
            assertThat(title).isEqualTo("Discover")
            assertThat(latestListingsListItems).isEmpty()
            assertThat(loadingVisible).isFalse()
            assertThat(contentVisible).isFalse()
            assertThat(errorVisible).isFalse()
        }
    }

    @Test fun `moveTo - loading - updates correctly`() {
        viewState.moveTo(Loading)

        viewState.binding.value?.run {
            assertThat(loadingVisible).isTrue()
            assertThat(contentVisible).isFalse()
            assertThat(errorVisible).isFalse()
        }
    }

    @Test fun `moveTo - content - updates correctly`() {
        val latestListings = listOf<LatestListingListItem>()
        viewState.moveTo(Content(latestListings))

        viewState.binding.value?.run {
            assertThat(latestListings).isEqualTo(latestListings)
            assertThat(loadingVisible).isFalse()
            assertThat(contentVisible).isTrue()
            assertThat(errorVisible).isFalse()
        }
    }

    @Test fun `moveTo - error - updates correctly`() {
        viewState.moveTo(Error)

        viewState.binding.value?.run {
            assertThat(loadingVisible).isFalse()
            assertThat(contentVisible).isFalse()
            assertThat(errorVisible).isTrue()
        }
    }
}