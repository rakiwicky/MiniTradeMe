package com.trademe.feature.home.internal.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.trademe.feature.home.R
import com.trademe.feature.home.databinding.HomeMainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: HomeMainActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.home_main_activity)
        binding.viewModel = viewModel

        viewModel.binding.observe(this) {
            binding.topAppBar.title = it.title
        }

        viewModel.fragment.observe(this) {
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            var fragment = fragmentManager.fragmentFactory.instantiate(ClassLoader.getSystemClassLoader(), it.name)
            transaction.replace(binding.homeContainer.id, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}