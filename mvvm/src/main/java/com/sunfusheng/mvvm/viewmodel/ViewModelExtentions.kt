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
fun <T : ViewModel> Context.getViewModel(@NonNull modelClass: Class<T>): T {
    if (this is FragmentActivity) {
        return ViewModelProvider(this).get(modelClass)
    }
    throw IllegalArgumentException("Context is not FragmentActivity!")
}

fun <T : ViewModel> FragmentActivity.getViewModel(@NonNull modelClass: Class<T>): T {
    return ViewModelProvider(this).get(modelClass)
}

fun <T : ViewModel> Fragment.getViewModel(@NonNull modelClass: Class<T>): T {
    return ViewModelProvider(this).get(modelClass)
}