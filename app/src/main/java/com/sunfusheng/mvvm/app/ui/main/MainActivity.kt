package com.sunfusheng.mvvm.app.ui.main

import android.content.Intent
import android.os.Bundle
import com.sunfusheng.StickyHeaderDecoration
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main) {

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
            item.clazz?.run {
                startActivity(Intent(this@MainActivity, item.clazz))
            }
        }
    }
}