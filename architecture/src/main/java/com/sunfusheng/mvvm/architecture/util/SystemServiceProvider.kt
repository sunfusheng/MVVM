package com.sunfusheng.mvvm.architecture.util

import android.content.res.Resources

/**
 * @author sunfusheng
 * @since 2020/4/4
 */
val resources: Resources by lazy {
    ContextHolder.context.resources
}