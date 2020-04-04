package com.sunfusheng.mvvm.architecture.app.ui.main

import androidx.lifecycle.ViewModel
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.app.ui.navigation.basic.BasicNavigationActivity
import com.sunfusheng.mvvm.architecture.app.ui.navigation.bottom_navigation_view.BottomNavigationViewActivity
import com.sunfusheng.mvvm.architecture.util.resources

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
class MainViewModel : ViewModel() {

    val dataSource by lazy {
        mainGroupDataSource {
            navigationGroup {
                item {
                    title = resources.getString(R.string.title_basic_navigation)
                    clazz = BasicNavigationActivity::class.java
                }
                item {
                    title = resources.getString(R.string.title_bottom_navigation_view)
                    clazz = BottomNavigationViewActivity::class.java
                }
            }
        }
    }
}