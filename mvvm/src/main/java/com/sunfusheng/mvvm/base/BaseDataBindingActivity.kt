package com.sunfusheng.mvvm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sunfusheng.mvvm.BR
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
        initDataBindingOnCreate()
    }

    private fun initDataBindingOnCreate() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = createViewModel()
        binding.lifecycleOwner = this
        lifecycle.addObserver(viewModel)
        binding.setVariable(BR.viewModel, viewModel)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun createViewModel(): VM
}