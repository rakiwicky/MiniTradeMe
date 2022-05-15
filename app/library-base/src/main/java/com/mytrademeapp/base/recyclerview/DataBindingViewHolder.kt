package com.mytrademeapp.base.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class DataBindingViewHolder<V : ViewDataBinding, M>(protected val ui: V) : RecyclerView.ViewHolder(ui.root) {

    abstract fun bind(model: M)

    companion object {
        fun <V : ViewDataBinding> createItemView(parentView: ViewGroup, layoutId: Int): V {
            return DataBindingUtil.inflate(LayoutInflater.from(parentView.context), layoutId, parentView, false)
        }
    }
}