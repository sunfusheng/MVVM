package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.base.BaseFragment
import com.sunfusheng.mvvm.architecture.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_basic_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BasicListFragment : BaseFragment(R.layout.fragment_basic_list) {

    private val viewModel by viewModel<BasicNavigationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar(getString(R.string.title_basic_navigation))

        addBackPressedCallback {
            ToastUtil.show("拦截 BasicListFragment 返回", Toast.LENGTH_LONG)
        }
        vRecyclerView.adapter = BasicAdapter(viewModel.dataSource)
    }
}