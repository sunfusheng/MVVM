package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunfusheng.mvvm.architecture.app.R
import kotlinx.android.synthetic.main.fragment_basic_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BasicListFragment : Fragment(R.layout.fragment_basic_list) {

    private val viewModel by viewModel<BasicNavigationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.title_basic_navigation)

        vRecyclerView.adapter = BasicAdapter(viewModel.dataSource)
    }
}