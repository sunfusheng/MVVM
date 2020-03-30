package com.sunfusheng.mvvm.architecture.app.ui.main

import androidx.lifecycle.ViewModel
import com.sunfusheng.mvvm.architecture.app.ui.navigation.BottomNavActivity
import com.sunfusheng.mvvm.architecture.app.ui.navigation.basic.BasicNavActivity

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
class MainViewModel : ViewModel() {

    val dataSource by lazy {
        mainGroupDataSource {
            navigationGroup {
                item {
                    title = "Navigation基本使用"
                    clazz = BasicNavActivity::class.java
                }
                item {
                    title = "BottomNavigation"
                    clazz = BottomNavActivity::class.java
                }
            }
        }
    }
}