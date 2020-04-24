package com.sunfusheng.mvvm.architecture.app.ui.main

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.sunfusheng.StickyHeaderDecoration
import com.sunfusheng.mvvm.architecture.app.R
import com.sunfusheng.mvvm.architecture.base.BaseActivity
import com.sunfusheng.mvvm.architecture.permission.LivePermissionResult
import com.sunfusheng.mvvm.architecture.permission.LivePermissions
import com.sunfusheng.mvvm.architecture.util.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadDataSource()
        testLivePermissions()
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

    private fun testLivePermissions() {
        LivePermissions(this).request(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ).observe(this, Observer {
            when (it) {
                is LivePermissionResult.Granted -> {
                    ToastUtil.show("Granted")
                }
                is LivePermissionResult.Denied -> {
                    it.permissions.forEach {
                        Log.d("sfs", "Denied: $it")
                    }
                    ToastUtil.show("Denied")
                }
                is LivePermissionResult.DeniedRationale -> {
                    it.permissions.forEach {
                        Log.d("sfs", "DeniedRationale: $it")
                    }
                    ToastUtil.show("DeniedRationale")
                }
            }
        })
    }
}