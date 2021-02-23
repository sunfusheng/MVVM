package com.sunfusheng.mvvm.viewmodel

import android.content.Context
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author sunfusheng
 * @since 2020/2/29
 */
inline fun <reified VM : ViewModel> Context.getViewModel(): VM {
    if (this is FragmentActivity) {
        return ViewModelProvider(this).get(VM::class.java)
    }
    throw IllegalArgumentException("Context is not FragmentActivity!")
}

inline fun <reified VM : ViewModel> FragmentActivity.getViewModel(): VM {
    return ViewModelProvider(this).get(VM::class.java)
}

inline fun <reified VM : ViewModel> Fragment.getViewModel(): VM {
    return ViewModelProvider(this).get(VM::class.java)
}