package com.sunfusheng.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sunfusheng.mvvm.viewmodel.BaseViewModel

/**
 * @author sunfusheng
 * @since 2020/4/20
 */
abstract class BaseDataBindingFragment<V : ViewDataBinding, VM : BaseViewModel> : BaseFragment() {

    lateinit var binding: V
    lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewDataBinding()
    }

    private fun initViewDataBinding() {
        viewModel = createViewModel()
        lifecycle.addObserver(viewModel)
        binding.lifecycleOwner = this
        binding.setVariable(getVariableId(), viewModel)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getVariableId(): Int
    abstract fun createViewModel(): VM
}