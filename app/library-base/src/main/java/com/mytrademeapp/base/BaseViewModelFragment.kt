package com.mytrademeapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelFragment<VM : BaseViewModel, UI : ViewDataBinding>(
    private val viewModelClass: Class<VM>
) : Fragment() {
    protected abstract val layoutId: Int

    protected lateinit var viewModel: VM

    protected var ui by autoCleared<UI>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = DataBindingUtil.inflate(inflater, layoutId, container, false)
        ui.lifecycleOwner = this
        return ui.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this)[viewModelClass]

        (viewModel as? LifecycleObserver)?.let { lifecycle.addObserver(it) }
    }
}