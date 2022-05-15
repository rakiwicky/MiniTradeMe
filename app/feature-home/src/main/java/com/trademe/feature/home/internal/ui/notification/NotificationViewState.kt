package com.trademe.feature.home.internal.ui.notification

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trademe.feature.home.R

internal class NotificationViewState(
    resources: Resources
) {

    private val _binding = MutableLiveData(
        NotificationViewStateBinding(
            title = resources.getString(R.string.home_notifications_screen_title),
        )
    )

    val binding: LiveData<NotificationViewStateBinding> = _binding
}