package com.sunfusheng.mvvm.base

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * @author sunfusheng
 * @since 2020/3/31
 */
abstract class BaseFragment(@LayoutRes val contentLayoutId: Int = 0) : Fragment(contentLayoutId) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    addBackPressedCallback { onBackPressed() }
  }

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

  /**
   * @return true-拦截，false-不拦截
   */
  open fun onBackPressed(): Boolean {
    return false
  }

  /**
   * @param block true；拦截，false-不拦截
   */
  protected fun addBackPressedCallback(block: () -> Boolean) {
    requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
      if (!block.invoke()) {
        remove()
        if (childFragmentManager.backStackEntryCount > 0) {
          childFragmentManager.popBackStackImmediate()
        } else {
          requireActivity().onBackPressedDispatcher.onBackPressed()
        }
      }
    }
  }
}