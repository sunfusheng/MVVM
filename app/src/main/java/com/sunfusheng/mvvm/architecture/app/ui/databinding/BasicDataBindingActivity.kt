package com.sunfusheng.mvvm.architecture.app.ui.databinding

import android.os.Bundle
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.app.databinding.ActivityBasicDatabindingBinding
import com.sunfusheng.mvvm.architecture.base.BaseActivity
import com.sunfusheng.mvvm.architecture.lifecycle.LifecycleHandler

/**
 * @author sunfusheng
 * @since 2020/4/14
 */
class BasicDataBindingActivity : BaseActivity() {

    private val mLifecycleHandler: LifecycleHandler = LifecycleHandler(this, Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActionBar(getString(R.string.title_basic_databinding), showHomeAsUp = true)

        val binding: ActivityBasicDatabindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_basic_databinding)

        binding.userInfo = UserInfo("sunfusheng")
        mLifecycleHandler.postDelayed({
            binding.userInfo = UserInfo("Hi, my name is sunfusheng.")
        }, 2000)
    }
}

data class UserInfo(val name: String, val gitHubUrl: String = "https://github.com/sunfusheng")