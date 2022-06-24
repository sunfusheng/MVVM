package com.sunfusheng.mvvm.app

import android.app.Application
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}
