package com.sunfusheng.mvvm.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author sunfusheng
 * @since  2021/02/25
 */
@BindingAdapter("adapter")
fun RecyclerView.adapter(adapter: RecyclerView.Adapter<*>) {
  setAdapter(adapter)
}