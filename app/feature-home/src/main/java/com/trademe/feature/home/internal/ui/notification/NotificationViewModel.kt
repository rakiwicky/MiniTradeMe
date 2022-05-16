package com.trademe.feature.home.internal.ui.notification

import com.mytrademeapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class NotificationViewModel @Inject constructor(
    viewStateFactory: NotificationViewState.Factory
) : BaseViewModel() {

    private val viewState = viewStateFactory.create()
    val binding = viewState.binding
}