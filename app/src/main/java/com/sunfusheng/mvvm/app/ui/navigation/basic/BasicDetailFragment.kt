package com.sunfusheng.mvvm.app.ui.navigation.basic

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.databinding.FragmentBasicDetailBinding
import com.sunfusheng.mvvm.base.BaseDBFragment
import com.sunfusheng.mvvm.util.ToastUtil

class BasicDetailFragment : BaseDBFragment<FragmentBasicDetailBinding>() {

    private val args: BasicDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActionBar(args.colorString)

        addBackPressedCallback {
            ToastUtil.show("addBackPressedCallback()")
            false
        }

        binding.vColor.setBackgroundColor(Color.parseColor(args.colorString))
    }

    override fun onBackPressed(): Boolean {
        ToastUtil.show("onBackPressed()")
        return false
    }

    override fun getLayoutId() = R.layout.fragment_basic_detail

}