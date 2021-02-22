package com.sunfusheng.mvvm.app.ui.databinding

import android.os.Bundle
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.databinding.ActivityBasicDatabindingBinding
import com.sunfusheng.mvvm.base.BaseDataBindingActivity
import com.sunfusheng.mvvm.viewmodel.BaseViewModel
import com.sunfusheng.mvvm.viewmodel.getViewModel

/**
 * @author sunfusheng
 * @since 2020/4/14
 */
class BasicDataBindingActivity :
    BaseDataBindingActivity<ActivityBasicDatabindingBinding, UserInfoViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActionBar(getString(R.string.title_basic_databinding), showHomeAsUp = true)
    }

    override fun getLayoutId(): Int = R.layout.activity_basic_databinding

    override fun createViewModel() = getViewModel(UserInfoViewModel::class.java)
}

class UserInfoViewModel : BaseViewModel() {

    companion object {
        const val GITHUB = "https://github.com/sunfusheng"
    }

    val username = ObservableField<String>().apply {
        set("sunfusheng")
    }

    val github = MutableLiveData<String>().apply {
        value = GITHUB
    }

    fun change() {
        username.set("Hi, my name is sunfusheng.")
        github.value = "For more information to visit: \n$GITHUB."
    }
}