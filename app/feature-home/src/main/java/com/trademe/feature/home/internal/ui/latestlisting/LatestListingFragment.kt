package com.trademe.feature.home.internal.ui.latestlisting

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mytrademeapp.base.BaseViewModelFragment
import com.mytrademeapp.base.autoCleared
import com.trademe.feature.home.R
import com.trademe.feature.home.databinding.HomeLatestListingFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class LatestListingFragment : BaseViewModelFragment<LatestListingViewModel, HomeLatestListingFragmentBinding>
    (LatestListingViewModel::class.java) {

    private var listAdapter by autoCleared<LatestListingListAdapter>()

    override val layoutId = R.layout.home_latest_listing_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ui.viewModel = viewModel
        listAdapter = LatestListingListAdapter { viewModel.itemSelected(it) }

        viewModel.binding.observe(viewLifecycleOwner) {
            print(it.title)
            listAdapter.dataSource = it.latestListingsListItems
        }

        ui.recyclerView.run {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            isNestedScrollingEnabled = false
            addItemDecoration(DividerItemDecoration(context, (layoutManager as LinearLayoutManager).orientation))
        }
    }
}