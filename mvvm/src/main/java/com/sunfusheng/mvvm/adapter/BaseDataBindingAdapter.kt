package com.sunfusheng.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @author sunfusheng
 * @since  2021/02/25
 */
abstract class BaseDataBindingAdapter<T, B : ViewDataBinding> :
    RecyclerView.Adapter<BaseDataBindingAdapter.DataBindingViewHolder<B>>() {

    private val data = mutableListOf<T>()

    fun setData(list: List<T>?) {
        data.clear()
        if (list?.isEmpty() == false) {
            data.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<B> {
        val binding = DataBindingUtil.inflate<B>(
            LayoutInflater.from(parent.context),
            getLayoutId(),
            parent,
            false
        )
        return DataBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<B>, position: Int) {
        onBind(holder.binding, data[position], position)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = data.size

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun onBind(binding: B, item: T, position: Int)

    open class DataBindingViewHolder<B : ViewDataBinding>(val binding: B) :
        RecyclerView.ViewHolder(binding.root)
}