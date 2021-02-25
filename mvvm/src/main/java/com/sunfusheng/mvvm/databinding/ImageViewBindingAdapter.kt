package com.sunfusheng.mvvm.databinding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author sunfusheng
 * @since  2021/02/25
 */

@BindingAdapter("image", "placeholder", requireAll = false)
fun ImageView.loadImage(imageUrl: String, @DrawableRes placeholderResId: Int) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(placeholderResId)
        .into(this)
}