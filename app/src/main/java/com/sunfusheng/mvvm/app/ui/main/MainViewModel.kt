package com.sunfusheng.mvvm.app.ui.main

import androidx.lifecycle.ViewModel
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.ui.databinding.BasicDataBindingActivity
import com.sunfusheng.mvvm.app.ui.navigation.basic.BasicNavigationActivity
import com.sunfusheng.mvvm.app.ui.navigation.bottom_navigation_view.BottomNavigationViewActivity
import com.sunfusheng.mvvm.util.resources

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
            databindingGroup {
                item {
                    title = resources.getString(R.string.title_basic_databinding)
                    clazz = BasicDataBindingActivity::class.java
                }
            }
        }
    }
}