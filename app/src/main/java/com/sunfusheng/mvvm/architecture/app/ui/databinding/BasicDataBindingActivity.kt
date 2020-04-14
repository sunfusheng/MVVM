package com.sunfusheng.mvvm.architecture.app.ui.databinding

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.app.databinding.ActivityBasicDatabindingBinding
import com.sunfusheng.mvvm.architecture.base.BaseActivity

/**
 * @author sunfusheng
 * @since 2020/4/14
 */
class BasicDataBindingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityBasicDatabindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_basic_databinding)

        binding.author = Author("sunfusheng", "https://github.com/sunfusheng")
    }
}