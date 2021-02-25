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
abstract class BaseDBVMActivity<V : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    lateinit var binding: V
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDBVM()
    }

    private fun initDBVM() {
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