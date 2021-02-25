package com.sunfusheng.mvvm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author sunfusheng
 * @since 2020/4/20
 */
abstract class BaseDBActivity<V : ViewDataBinding> : BaseActivity() {

    lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDBVM()
    }

    private fun initDBVM() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}