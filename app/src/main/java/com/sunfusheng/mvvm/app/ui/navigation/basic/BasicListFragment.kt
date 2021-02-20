package com.sunfusheng.mvvm.app.ui.navigation.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_basic_list.*

class BasicListFragment : BaseFragment(R.layout.fragment_basic_list) {

    private val viewModel by viewModels<BasicNavigationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar(getString(R.string.title_basic_navigation))

        vRecyclerView.adapter = BasicAdapter(viewModel.dataSource)
    }
}