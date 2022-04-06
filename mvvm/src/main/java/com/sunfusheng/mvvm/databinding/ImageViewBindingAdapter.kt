package com.sunfusheng.mvvm.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author sunfusheng
 * @since  2021/02/25
 */

@BindingAdapter(value = ["imageUrl", "placeholder", "error"], requireAll = false)
fun ImageView.loadImage(
  imageUrl: String,
  placeholder: Drawable,
  error: Drawable
) {
  Glide.with(context)
    .load(imageUrl)
    .placeholder(placeholder)
    .error(error)
    .into(this)
}