package com.trademe.feature.home

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mytrademeapp.base.test.applicationContext
import com.google.common.truth.Truth.assertThat
import com.trademe.feature.home.internal.ui.main.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeNavigationTest {

    private val navigation by lazy { HomeNavigation(applicationContext) }

    @Test fun `createMainActivityIntent - produces correct intent`() {
        navigation.createMainActivityIntent().run {
            assertThat(component?.className).isEqualTo(MainActivity::class.qualifiedName)
        }
    }
}