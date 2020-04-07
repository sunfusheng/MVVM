package com.sunfusheng.mvvm.architecture.base

import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * @author sunfusheng
 * @since 2020/3/31
 */
open class BaseFragment(@LayoutRes val contentLayoutId: Int = 0) : Fragment(contentLayoutId) {

    protected fun initActionBar(
        title: String,
        subtitle: String = "",
        showHomeAsUp: Boolean = true
    ) {
        val activity = requireActivity()
        if (activity is AppCompatActivity) {
            val actionBar: ActionBar? = activity.supportActionBar
            if (actionBar != null) {
                actionBar.title = title
                actionBar.subtitle = subtitle
                actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp)
            }
        }
    }

    // true: 拦截，false: 不拦截
    protected fun addBackPressedCallback(block: () -> Boolean) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (!block.invoke()) {
                isEnabled = childFragmentManager.backStackEntryCount > 0
                if (isEnabled) {
                    childFragmentManager.popBackStackImmediate()
                } else {
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
}