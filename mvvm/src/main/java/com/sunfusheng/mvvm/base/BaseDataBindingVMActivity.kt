package com.sunfusheng.mvvm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 * @author sunfusheng
 * @since 2020/4/20
 */
abstract class BaseDataBindingVMActivity<V : ViewDataBinding, VM : ViewModel> : BaseActivity() {

  lateinit var binding: V
  lateinit var viewModel: VM

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initDataBindingVM()
  }

  private fun initDataBindingVM() {
    binding = DataBindingUtil.setContentView(this, getLayoutId())
    viewModel = createViewModel()
    binding.lifecycleOwner = this
    binding.setVariable(getVariableId(), viewModel)
  }

  @LayoutRes
  abstract fun getLayoutId(): Int

  abstract fun createViewModel(): VM

  abstract fun getVariableId(): Int
}