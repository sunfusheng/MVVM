package com.sunfusheng.mvvm.architecture.util

import android.widget.Toast

/**
 * @author sunfusheng
 * @since 2020/4/5
 */
object ToastUtil {

    fun show(text: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(ContextHolder.context, text, duration).show()
    }
}