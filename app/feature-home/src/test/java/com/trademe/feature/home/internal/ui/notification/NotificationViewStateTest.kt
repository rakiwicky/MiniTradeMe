package com.trademe.feature.home.internal.ui.notification

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import com.mytrademeapp.base.test.applicationResources

@RunWith(AndroidJUnit4::class)
class NotificationViewStateTest {

    private val viewState = NotificationViewState(applicationResources)

    @Test
    fun `verify - initial state`() {
        viewState.binding.value?.run {
            assertThat(title).isEqualTo("Notifications")
            assertThat(title).isEqualTo("Notifications")
            assertThat(title).isEqualTo("Notifications")
            assertThat(title).isEqualTo("Notifications")
            assertThat(title).isEqualTo("Notifications")
        }
    }
}