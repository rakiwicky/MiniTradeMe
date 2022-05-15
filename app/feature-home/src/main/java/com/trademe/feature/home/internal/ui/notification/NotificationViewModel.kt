package com.trademe.feature.home.internal.ui.notification

import android.content.res.Resources
import com.mytrademeapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class NotificationViewModel @Inject constructor(
    resources: Resources
) : BaseViewModel() {

    private val viewState = NotificationViewState(resources)
    val binding = viewState.binding
}