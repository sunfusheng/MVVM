package com.sunfusheng.mvvm.extension

import android.view.View

/**
 * @author sunfusheng
 * @since 2020/3/31
 */
fun View.visible() {
  if (visibility != View.VISIBLE) {
    visibility = View.VISIBLE
  }
}

fun View.invisible() {
  if (visibility != View.INVISIBLE) {
    visibility = View.INVISIBLE
  }
}

fun View.gone() {
  if (visibility != View.GONE) {
    visibility = View.GONE
  }
}