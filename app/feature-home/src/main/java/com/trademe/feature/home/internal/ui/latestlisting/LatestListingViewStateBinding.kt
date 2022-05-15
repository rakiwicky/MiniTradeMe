package com.trademe.feature.home.internal.ui.latestlisting

internal data class LatestListingViewStateBinding(
    val title: String,
    val latestListingsListItems: List<LatestListingListItem>,
    val contentVisible: Boolean,
    val errorVisible: Boolean,
    val loadingVisible: Boolean
)