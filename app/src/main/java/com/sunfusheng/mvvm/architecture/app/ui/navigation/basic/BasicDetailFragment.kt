package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sunfusheng.mvvm.architecture.app.R
import kotlinx.android.synthetic.main.fragment_basic_detail.*

class BasicDetailFragment : Fragment(R.layout.fragment_basic_detail) {

    private val args: BasicDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().title = args.colorString

        vRoot.setBackgroundColor(Color.parseColor(args.colorString))
    }
}
