package com.mytrademeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trademe.feature.home.HomeNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivityOne : AppCompatActivity() {

    @Inject lateinit var homeNavigation: HomeNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_one)

        startActivity(homeNavigation.createItemMainActivityIntent())
    }
}