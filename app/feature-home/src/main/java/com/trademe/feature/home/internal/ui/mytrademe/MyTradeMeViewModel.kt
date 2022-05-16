package com.trademe.feature.home.internal.ui.mytrademe

import com.mytrademeapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MyTradeMeViewModel @Inject constructor(
    viewStateFactory: MyTradeMeViewState.Factory
) : BaseViewModel() {

    private val viewState = viewStateFactory.create()
    val binding = viewState.binding
}