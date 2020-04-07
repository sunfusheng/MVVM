package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import androidx.lifecycle.ViewModel

/**
 * @author sunfusheng
 * @since 2020/3/30
 */
class BasicNavigationViewModel : ViewModel() {

    val dataSource by lazy {
        val list = ArrayList<String>()
        list.add("#FFE0B2")
        list.add("#FFCC80")
        list.add("#FFB74D")
        list.add("#FFA726")
        list.add("#FF9800")
        list.add("#FB8C00")
        list.add("#F57C00")
        list.add("#Ef6C00")
        list.add("#E65100")
        list
    }
}