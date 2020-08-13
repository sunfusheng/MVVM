package com.sunfusheng.mvvm.util

import android.content.res.AssetManager
import android.content.res.Resources

/**
 * @author sunfusheng
 * @since 2020/4/4
 */
val resources: Resources by lazy { ContextHolder.context.resources }

val assets: AssetManager by lazy { ContextHolder.context.assets }