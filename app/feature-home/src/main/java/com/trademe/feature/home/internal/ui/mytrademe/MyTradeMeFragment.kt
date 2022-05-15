package com.trademe.feature.home.internal.ui.mytrademe

import android.os.Bundle
import com.mytrademeapp.base.BaseViewModelFragment
import com.trademe.feature.home.R
import com.trademe.feature.home.databinding.HomeMytrademeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MyTradeMeFragment : BaseViewModelFragment<MyTradeMeViewModel, HomeMytrademeFragmentBinding>(
    MyTradeMeViewModel::class.java) {

    override val layoutId = R.layout.home_mytrademe_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ui.viewModel = viewModel
    }
}