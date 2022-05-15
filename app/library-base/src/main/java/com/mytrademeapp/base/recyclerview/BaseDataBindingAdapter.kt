package com.mytrademeapp.base.recyclerview

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseDataBindingAdapter<V : ViewDataBinding, M : Any> : RecyclerView.Adapter<DataBindingViewHolder<V, M>>() {
    var dataSource = listOf<M>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    abstract val viewHolderLayoutId: Int

    abstract fun bind(ui: V, model: M)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<V, M> {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<V, M>, position: Int) {
        holder.bind(dataSource[position])
    }

    private inner class ViewHolder(parent: ViewGroup) :
        DataBindingViewHolder<V, M>(createItemView(parent, viewHolderLayoutId)) {

        override fun bind(model: M) {
            bind(ui, model)
            ui.executePendingBindings()
        }
    }
}