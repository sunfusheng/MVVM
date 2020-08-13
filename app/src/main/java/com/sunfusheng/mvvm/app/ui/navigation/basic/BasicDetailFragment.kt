package com.sunfusheng.mvvm.app.ui.navigation.basic

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.base.BaseFragment
import com.sunfusheng.mvvm.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_basic_detail.*

class BasicDetailFragment : BaseFragment(R.layout.fragment_basic_detail) {

    private val args: BasicDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar(args.colorString)

        addBackPressedCallback {
            ToastUtil.show("addBackPressedCallback()")
            false
        }

        vColor.setBackgroundColor(Color.parseColor(args.colorString))
    }

    override fun onBackPressed(): Boolean {
        ToastUtil.show("onBackPressed()")
        return false
    }
}