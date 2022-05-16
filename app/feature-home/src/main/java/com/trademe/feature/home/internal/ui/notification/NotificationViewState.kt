package com.trademe.feature.home.internal.ui.notification

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trademe.feature.home.R
import javax.inject.Inject

internal class NotificationViewState(
    resources: Resources
) {

    private val _binding = MutableLiveData(
        NotificationViewStateBinding(
            title = resources.getString(R.string.home_notifications_screen_title),
        )
    )

    val binding: LiveData<NotificationViewStateBinding> = _binding

    class Factory @Inject constructor(private val resources: Resources) {
        fun create(
        ) = NotificationViewState(resources)
    }
}