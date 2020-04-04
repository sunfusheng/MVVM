package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import androidx.lifecycle.ViewModel

/**
 * @author sunfusheng
 * @since 2020/3/30
 */
class BasicNavigationViewModel : ViewModel() {

    val dataSource by lazy {
        val list = ArrayList<String>()
        list.add("#ffe0b2")
        list.add("#ffcc80")
        list.add("#ffb74d")
        list.add("#ffa726")
        list.add("#ff9800")
        list.add("#fb8c00")
        list.add("#f57c00")
        list.add("#ef6c00")
        list.add("#e65100")
        list
    }
}