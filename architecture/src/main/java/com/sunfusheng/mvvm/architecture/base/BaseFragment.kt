package com.sunfusheng.mvvm.architecture.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author sunfusheng
 * @since 2020/3/31
 */
class BaseFragment(@LayoutRes val contentLayoutId: Int = 0) : Fragment(contentLayoutId) {

}