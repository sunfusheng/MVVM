package com.sunfusheng.mvvm.architecture.base

import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

/**
 * @author sunfusheng
 * @since 2020/3/27
 */
abstract class BaseActivity(@LayoutRes val contentLayoutId: Int = 0) :
    AppCompatActivity(contentLayoutId) {

    protected fun initActionBar(
        title: String,
        subtitle: String = "",
        showHomeAsUp: Boolean = true
    ) {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.title = title
            actionBar.subtitle = subtitle
            actionBar.setDisplayHomeAsUpEnabled(showHomeAsUp)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}