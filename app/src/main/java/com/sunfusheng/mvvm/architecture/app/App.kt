package com.sunfusheng.mvvm.architecture.app

import android.app.Application
import com.sunfusheng.mvvm.architecture.app.ui.main.MainViewModel
import com.sunfusheng.mvvm.architecture.app.ui.navigation.basic.BasicNavViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            androidFileProperties()
            modules(appModules)
        }
    }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { BasicNavViewModel() }
}

val repositoryModule = module {

}

val appModules = listOf(viewModelModule, repositoryModule)