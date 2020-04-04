package com.sunfusheng.mvvm.architecture.util

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.sunfusheng.mvvm.architecture.util.ContextHolder

/**
 * @author sunfusheng
 * @since 2020/3/31
 */
class ArchitectureProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        initApp(context!!.applicationContext)
        return true
    }

    private fun initApp(context: Context) {
        ContextHolder.context = context
        ContextHolder.app = context as Application
        Log.d("sfs", "ArchitectureProvider onCreate() $context")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int = 0

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? = null

    override fun getType(uri: Uri): String? = null
}