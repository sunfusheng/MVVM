package com.sunfusheng.mvvm.app.ui.navigation.basic

import android.os.Bundle
import android.view.View
import com.sunfusheng.mvvm.app.BR
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.databinding.FragmentBasicListBinding
import com.sunfusheng.mvvm.base.BaseDataBindingVMFragment
import com.sunfusheng.mvvm.viewmodel.BaseViewModel
import com.sunfusheng.mvvm.viewmodel.getViewModel

class BasicListFragment : BaseDataBindingVMFragment<FragmentBasicListBinding, BasicNavigationViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar(getString(R.string.title_basic_navigation))

        binding.vRecyclerView.adapter = BasicAdapter(viewModel.dataSource)
    }

    override fun getLayoutId() = R.layout.fragment_basic_list

    override fun createViewModel(): BasicNavigationViewModel = getViewModel()

    override fun getVariableId() = BR.viewModel
}

class BasicNavigationViewModel : BaseViewModel() {

    val dataSource by lazy {
        val list = ArrayList<String>()
        list.add("#FFE0B2")
        list.add("#FFCC80")
        list.add("#FFB74D")
        list.add("#FFA726")
        list.add("#FF9800")
        list.add("#FB8C00")
        list.add("#F57C00")
        list.add("#Ef6C00")
        list.add("#E65100")
        list
    }
}