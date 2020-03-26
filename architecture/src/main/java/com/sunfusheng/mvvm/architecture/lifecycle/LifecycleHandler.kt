package com.sunfusheng.mvvm.architecture.lifecycle

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * @author sunfusheng
 * @since 2020/3/14
 */
class LifecycleHandler : Handler, DefaultLifecycleObserver {
    private var lifecycleOwner: LifecycleOwner

    constructor(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    constructor(lifecycleOwner: LifecycleOwner, looper: Looper) : super(looper) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    constructor(lifecycleOwner: LifecycleOwner, callback: Callback) : super(callback) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    constructor(lifecycleOwner: LifecycleOwner, looper: Looper, callback: Callback) : super(
        looper,
        callback
    ) {
        this.lifecycleOwner = lifecycleOwner
        addObserver()
    }

    private fun addObserver() {
        this.lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        removeCallbacksAndMessages(null)
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}