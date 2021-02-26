package com.sunfusheng.mvvm.app.ui.databinding

import android.os.Bundle
import com.sunfusheng.mvvm.adapter.BaseDataBindingAdapter
import com.sunfusheng.mvvm.app.BR
import com.sunfusheng.mvvm.app.Charlie_Munger_Avatar
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.Warren_Buffett_Avatar
import com.sunfusheng.mvvm.app.databinding.ActivityBaRvDatabindingBinding
import com.sunfusheng.mvvm.app.databinding.ItemBindingadapterBinding
import com.sunfusheng.mvvm.base.BaseDBVMActivity
import com.sunfusheng.mvvm.util.ToastUtil
import com.sunfusheng.mvvm.viewmodel.BaseViewModel
import com.sunfusheng.mvvm.viewmodel.getViewModel

/**
 * @author sunfusheng
 * @since  2021/02/25
 */
class BindingAdapterRecyclerViewDBActivity :
    BaseDBVMActivity<ActivityBaRvDatabindingBinding, BindingAdapterTestVM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActionBar(getString(R.string.title_bindingadapter_recyclerview_databinding))

        val adapter = BindingAdapterTestAdapter()
        adapter.setData(viewModel.data)
        binding.adapter = adapter
    }

    override fun getLayoutId() = R.layout.activity_ba_rv_databinding

    override fun createViewModel(): BindingAdapterTestVM = getViewModel()

    override fun getVariableId() = BR.vm
}

class BindingAdapterTestVM : BaseViewModel() {

    val data by lazy {
        val list = mutableListOf<User>()
        list.add(User("沃伦·巴菲特", Warren_Buffett_Avatar))
        list.add(User("查理·芒格", Charlie_Munger_Avatar))
        list
    }
}

data class User(val name: String, val avatar: String)

class BindingAdapterTestAdapter : BaseDataBindingAdapter<User, ItemBindingadapterBinding>() {

    override fun getLayoutId() = R.layout.item_bindingadapter

    override fun onBind(binding: ItemBindingadapterBinding, item: User, position: Int) {
        binding.user = item
        binding.root.setOnClickListener {
            ToastUtil.show(item.name)
        }
    }
}
