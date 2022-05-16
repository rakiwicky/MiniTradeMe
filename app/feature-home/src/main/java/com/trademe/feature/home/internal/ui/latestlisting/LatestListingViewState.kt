package com.trademe.feature.home.internal.ui.latestlisting

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.trademe.feature.home.R
import com.trademe.feature.home.internal.ui.latestlisting.LatestListingViewState.TargetState.*
import javax.inject.Inject

internal class LatestListingViewState(
    resources: Resources
) {

    private val _binding = MutableLiveData(
        LatestListingViewStateBinding(
            title = resources.getString(R.string.home_latestlisting_screen_title),
            latestListingsListItems = emptyList(),
            loadingVisible = false,
            contentVisible = false,
            errorVisible = false
        )
    )

    val binding: LiveData<LatestListingViewStateBinding> = _binding

    fun moveTo(targetState: TargetState) {
        val currentState = _binding.value

        _binding.value = when (targetState) {
            is Content -> currentState!!.copy(
                latestListingsListItems = targetState.list,
                loadingVisible = false,
                contentVisible = true,
                errorVisible = false
            )
            Loading -> currentState!!.copy(
                loadingVisible = true,
                contentVisible = false,
                errorVisible = false
            )
            Error -> currentState!!.copy(
                loadingVisible = false,
                contentVisible = false,
                errorVisible = true
            )
        }
    }

    class Factory @Inject constructor(private val resources: Resources) {
        fun create(
        ) = LatestListingViewState(resources)
    }

    sealed class TargetState {
        data class Content(val list: List<LatestListingListItem>) : TargetState()
        object Loading : TargetState()
        object Error : TargetState()
    }
}