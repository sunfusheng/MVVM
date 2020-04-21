package com.sunfusheng.mvvm.architecture.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sunfusheng.mvvm.architecture.viewmodel.BaseViewModel

/**
 * @author sunfusheng
 * @since 2020/4/20
 */
abstract class BaseDataBindingActivity<V : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    protected lateinit var binding: V
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        initViewDataBinding()
    }

    private fun initViewDataBinding() {
        viewModel = initViewModel()
        binding.lifecycleOwner = this
        binding.setVariable(getVariableId(), viewModel)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getVariableId(): Int
    abstract fun initViewModel(): VM
}