package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_basic_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BasicListFragment : Fragment(R.layout.fragment_basic_list) {

    private val viewModel by viewModel<BasicNavigationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.title_basic_navigation)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            ToastUtil.show("拦截 BasicListFragment 返回", Toast.LENGTH_LONG)
            isEnabled = childFragmentManager.backStackEntryCount > 0
            if (isEnabled) childFragmentManager.popBackStackImmediate()
            else requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        vRecyclerView.adapter = BasicAdapter(viewModel.dataSource)
    }
}