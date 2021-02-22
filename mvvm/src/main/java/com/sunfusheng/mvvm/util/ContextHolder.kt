package com.sunfusheng.mvvm.util

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author sunfusheng
 * @since 2020/3/31
 */
@SuppressLint("StaticFieldLeak")
object ContextHolder {
    lateinit var context: Context
    lateinit var app: Application
}