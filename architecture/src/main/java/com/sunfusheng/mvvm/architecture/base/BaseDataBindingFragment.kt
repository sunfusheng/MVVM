package com.sunfusheng.mvvm.architecture.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.sunfusheng.mvvm.architecture.viewmodel.BaseViewModel

/**
 * @author sunfusheng
 * @since 2020/4/20
 */
abstract class BaseDataBindingFragment<V : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: V
    protected lateinit var viewModel: VM

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
        viewModel = initViewModel()
        binding.lifecycleOwner = this
        binding.setVariable(getVariableId(), viewModel)
    }

    abstract fun getLayoutId(): Int
    abstract fun getVariableId(): Int
    abstract fun initViewModel(): VM
}