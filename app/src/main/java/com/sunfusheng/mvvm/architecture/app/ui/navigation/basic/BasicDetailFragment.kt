package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_basic_detail.*

class BasicDetailFragment : Fragment(R.layout.fragment_basic_detail) {

    private val args: BasicDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = args.colorString

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            ToastUtil.show("拦截 BasicDetailFragment 返回", Toast.LENGTH_LONG)
            isEnabled = childFragmentManager.backStackEntryCount > 0
            if (isEnabled) childFragmentManager.popBackStackImmediate()
            else requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        vColor.setBackgroundColor(Color.parseColor(args.colorString))
    }
}