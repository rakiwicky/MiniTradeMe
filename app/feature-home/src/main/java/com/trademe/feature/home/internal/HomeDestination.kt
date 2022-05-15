package com.trademe.feature.home.internal

import com.trademe.feature.home.internal.ui.latestlisting.LatestListingFragment
import com.trademe.feature.home.internal.ui.mytrademe.MyTradeMeFragment
import com.trademe.feature.home.internal.ui.notification.NotificationFragment
import com.trademe.feature.home.internal.ui.watchlist.WatchlistFragment

internal enum class HomeDestination(val fragmentClass: Class<*>) {
    LATESTLISTING(LatestListingFragment::class.java),
    NOTIFICATIONS(NotificationFragment::class.java),
    WATCHLIST(WatchlistFragment::class.java),
    MYTRADEME(MyTradeMeFragment::class.java)
}