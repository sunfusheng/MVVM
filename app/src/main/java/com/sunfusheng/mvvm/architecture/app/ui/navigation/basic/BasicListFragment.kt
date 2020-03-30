package com.sunfusheng.mvvm.architecture.app.ui.navigation.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunfusheng.mvvm.architecture.app.R
import kotlinx.android.synthetic.main.fragment_basic_list.*

class BasicListFragment : Fragment(R.layout.fragment_basic_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataSource = ArrayList<BasicItem>()
        for (i in 1..20) {
            dataSource.add(BasicItem("Cherry$i", resources.getDrawable(R.mipmap.cherry)))
        }
        vRecyclerView.adapter = BasicAdapter(dataSource)
    }
}