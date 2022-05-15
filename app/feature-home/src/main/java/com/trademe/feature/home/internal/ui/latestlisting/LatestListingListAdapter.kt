package com.trademe.feature.home.internal.ui.latestlisting

import com.mytrademeapp.base.recyclerview.BaseDataBindingAdapter
import com.trademe.feature.home.R
import com.trademe.feature.home.databinding.HomeLatestListingListItemBinding

internal class LatestListingListAdapter(
    private val clickListener: (LatestListingListItem) -> Unit
) : BaseDataBindingAdapter<HomeLatestListingListItemBinding, LatestListingListItem>() {
    override val viewHolderLayoutId = R.layout.home_latest_listing_list_item

    override fun bind(ui: HomeLatestListingListItemBinding, model: LatestListingListItem) {
        ui.model = model
        ui.root.setOnClickListener { clickListener(model) }
    }
}