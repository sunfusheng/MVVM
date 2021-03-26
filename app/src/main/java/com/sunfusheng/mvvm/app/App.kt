package com.sunfusheng.mvvm.app

import android.app.Application
import android.util.Log
import com.tencent.mmkv.MMKV

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
}
