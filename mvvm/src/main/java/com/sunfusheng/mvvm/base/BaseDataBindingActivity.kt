package com.sunfusheng.mvvm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sunfusheng.mvvm.viewmodel.BaseViewModel

/**
 * @author sunfusheng
 * @since 2020/4/20
 */
abstract class BaseDataBindingActivity<V : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    lateinit var binding: V
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewDataBindingOnCreate()
    }

    private fun initViewDataBindingOnCreate() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = createViewModel()
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
        binding.setVariable(getVariableId(), viewModel)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getVariableId(): Int
    abstract fun createViewModel(): VM
}