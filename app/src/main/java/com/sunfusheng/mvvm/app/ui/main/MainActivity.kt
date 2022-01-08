package com.sunfusheng.mvvm.app.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.sunfusheng.StickyHeaderDecoration
import com.sunfusheng.mvvm.app.BR
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.databinding.ActivityMainBinding
import com.sunfusheng.mvvm.base.BaseDataBindingVMActivity
import com.sunfusheng.mvvm.viewmodel.getViewModel

class MainActivity : BaseDataBindingVMActivity<ActivityMainBinding, MainViewModel>() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    loadDataSource()
  }

  private fun loadDataSource() {
    binding.vRecyclerView.addItemDecoration(StickyHeaderDecoration())
    val adapter = MainStickyGroupAdapter(this, viewModel.dataSource)
    binding.vRecyclerView.adapter = adapter

    adapter.setOnItemClickListener { _, item, _, _ ->
      item.clazz?.run {
        startActivity(Intent(this@MainActivity, item.clazz))
      }
    }
  }

  override fun getLayoutId() = R.layout.activity_main

  override fun createViewModel(): MainViewModel = getViewModel()

  override fun getVariableId() = BR.viewModel
}