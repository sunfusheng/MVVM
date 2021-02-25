package com.sunfusheng.mvvm.app.ui.databinding

import android.os.Bundle
import com.sunfusheng.mvvm.adapter.BaseDataBindingAdapter
import com.sunfusheng.mvvm.app.BR
import com.sunfusheng.mvvm.app.R
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
        list.add(
            User(
                "巴菲特",
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20181019%2F8216a9ce2aa840f18a369553f4a8980c.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616847790&t=72cd4fc74db672a2ad26b4932bea0ec0"
            )
        )
        list.add(
            User(
                "查理芒格",
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg3.gelonghui.com%2F9f8cd-bf1f796b-b477-4582-8256-2d11c1c8c109.png%3Fx-oss-process%3Dstyle%2Fwm&refer=http%3A%2F%2Fimg3.gelonghui.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616847934&t=9606ff3c954979500cbd653a56d308a4"
            )
        )
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
