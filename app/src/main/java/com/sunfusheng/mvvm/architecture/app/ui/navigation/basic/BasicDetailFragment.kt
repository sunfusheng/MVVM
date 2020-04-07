package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.base.BaseFragment
import com.sunfusheng.mvvm.architecture.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_basic_detail.*

class BasicDetailFragment : BaseFragment(R.layout.fragment_basic_detail) {

    private val args: BasicDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar(args.colorString)

        addBackPressedCallback {
            ToastUtil.show("拦截 BasicDetailFragment 返回", Toast.LENGTH_LONG)
        }

        vColor.setBackgroundColor(Color.parseColor(args.colorString))
    }
}