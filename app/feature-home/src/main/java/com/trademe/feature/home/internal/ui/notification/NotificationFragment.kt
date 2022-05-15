package com.trademe.feature.home.internal.ui.notification

import android.os.Bundle
import com.mytrademeapp.base.BaseViewModelFragment
import com.trademe.feature.home.R
import com.trademe.feature.home.databinding.HomeNotificationFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class NotificationFragment : BaseViewModelFragment<NotificationViewModel, HomeNotificationFragmentBinding>(
    NotificationViewModel::class.java) {

    override val layoutId = R.layout.home_notification_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        ui.viewModel = viewModel
    }
}