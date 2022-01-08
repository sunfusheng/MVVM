package com.sunfusheng.mvvm.app.ui.motionlayout

import android.os.Bundle
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.base.BaseActivity
import com.sunfusheng.mvvm.base.BaseDataBindingActivity

/**
 * @author sunfusheng
 * @since  2022/01/08
 */
class SimpleMotionLayoutActivity : BaseActivity(R.layout.activity_simple_motion_layout) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initActionBar(getString(R.string.title_simple_motion_layout), showHomeAsUp = true)
  }
}