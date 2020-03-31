package com.sunfusheng.mvvm.architecture.util

import android.app.Application
import android.content.Context

/**
 * @author sunfusheng
 * @since 2020/3/31
 */
object ContextHolder {
    lateinit var context: Context
    lateinit var app: Application
}