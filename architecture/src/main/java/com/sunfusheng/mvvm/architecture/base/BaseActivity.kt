package com.sunfusheng.mvvm.architecture.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * @author sunfusheng
 * @since 2020/3/27
 */
abstract class BaseActivity(@LayoutRes val contentLayoutId: Int = 0) :
    AppCompatActivity(contentLayoutId) {

}