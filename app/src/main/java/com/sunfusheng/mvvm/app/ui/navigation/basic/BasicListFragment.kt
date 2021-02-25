package com.sunfusheng.mvvm.app.ui.navigation.basic

import android.os.Bundle
import android.view.View
import com.sunfusheng.mvvm.app.BR
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.databinding.FragmentBasicListBinding
import com.sunfusheng.mvvm.base.BaseDBVMFragment
import com.sunfusheng.mvvm.viewmodel.getViewModel

class BasicListFragment : BaseDBVMFragment<FragmentBasicListBinding, BasicNavigationViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar(getString(R.string.title_basic_navigation))

        binding.vRecyclerView.adapter = BasicAdapter(viewModel.dataSource)
    }

    override fun getLayoutId() = R.layout.fragment_basic_list

    override fun createViewModel(): BasicNavigationViewModel = getViewModel()

    override fun getVariableId() = BR.viewModel
}