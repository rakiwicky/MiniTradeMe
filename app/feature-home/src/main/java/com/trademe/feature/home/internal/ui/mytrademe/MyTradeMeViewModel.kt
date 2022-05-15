package com.trademe.feature.home.internal.ui.mytrademe

import android.content.res.Resources
import com.mytrademeapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MyTradeMeViewModel @Inject constructor(
    resources: Resources
) : BaseViewModel() {

    private val viewState = MyTradeMeViewState(resources)
    val binding = viewState.binding
}