package com.trademe.feature.home.internal.ui.mytrademe

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trademe.feature.home.R
import javax.inject.Inject

internal class MyTradeMeViewState(
    resources: Resources
) {

    private val _binding = MutableLiveData(
        MyTradeMeViewStateBinding(
            title = resources.getString(R.string.home_mytrademe_screen_title),
        )
    )

    val binding: LiveData<MyTradeMeViewStateBinding> = _binding

    class Factory @Inject constructor(private val resources: Resources) {
        fun create(
        ) = MyTradeMeViewState(resources)
    }
}