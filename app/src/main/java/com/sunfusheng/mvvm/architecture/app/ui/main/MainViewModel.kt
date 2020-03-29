package com.sunfusheng.mvvm.architecture.app.ui.main

import androidx.lifecycle.ViewModel

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
class MainViewModel : ViewModel() {

    val dataSource by lazy {
        mainGroupDataSource {
            navigationGroup {
                item {
                    title = "N1"
                }
                item {
                    title = "N2"
                }
            }
        }
    }
}