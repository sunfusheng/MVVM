package com.sunfusheng.mvvm.app.ui.databinding

import android.os.Bundle
import androidx.databinding.ObservableField
import com.sunfusheng.mvvm.app.BR
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.databinding.ActivityTwowayDatabindingBinding
import com.sunfusheng.mvvm.base.BaseDataBindingVMActivity
import com.sunfusheng.mvvm.viewmodel.BaseViewModel
import com.sunfusheng.mvvm.viewmodel.getViewModel

/**
 * @author sunfusheng
 * @since  2021/02/25
 */
class TwoWayDBActivity : BaseDataBindingVMActivity<ActivityTwowayDatabindingBinding, TwowayTestVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActionBar(getString(R.string.title_twoway_databinding), showHomeAsUp = true)
    }

    override fun getLayoutId() = R.layout.activity_twoway_databinding

    override fun createViewModel(): TwowayTestVM = getViewModel()

    override fun getVariableId() = BR.vm

}

class TwowayTestVM : BaseViewModel() {

    val databinding = ObservableField<String>().apply {
        set("databinding")
    }
}