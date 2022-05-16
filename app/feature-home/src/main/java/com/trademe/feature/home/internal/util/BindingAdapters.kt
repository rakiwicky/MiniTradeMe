package com.trademe.feature.home.internal.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class BindingAdapters {

    companion object{
        @JvmStatic
        @BindingAdapter("onNavigationItemSelected")
        fun setOnNavigationItemSelectedListener(view: BottomNavigationView, listener: NavigationBarView.OnItemSelectedListener?) {
            view.setOnItemSelectedListener(listener)
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            Glide.with(view.context)
                .load(url)
                .into(view)
        }

        @JvmStatic
        @BindingAdapter("isVisible")
        fun isVisible(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}