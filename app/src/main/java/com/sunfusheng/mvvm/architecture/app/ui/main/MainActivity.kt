package com.sunfusheng.mvvm.architecture.app.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunfusheng.StickyHeaderDecoration
import com.sunfusheng.mvvm.architecture.app.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadDataSource()
    }

    private fun loadDataSource() {
        vRecyclerView.addItemDecoration(StickyHeaderDecoration())
        val adapter = MainStickyGroupAdapter(this, viewModel.dataSource)
        vRecyclerView.adapter = adapter

        adapter.setOnItemClickListener { _, item, _, _ ->

        }
    }
}
