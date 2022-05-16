package com.trademe.feature.home

import android.content.Context
import android.content.Intent
import com.trademe.feature.home.internal.ui.main.MainActivity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class HomeNavigation @Inject constructor(
    @ActivityContext private val context: Context
) {
    fun createMainActivityIntent() = Intent(context, MainActivity::class.java)
}