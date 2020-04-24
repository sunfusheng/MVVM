package com.sunfusheng.mvvm.architecture.permission

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData

/**
 * @author sunfusheng
 * @since 2020/4/24
 */
internal class LivePermissionsFragment : Fragment() {

    companion object {
        private const val PERMISSIONS_REQUEST_CODE = 10000
    }

    val liveData by lazy { MutableLiveData<LivePermissionResult>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissions(permissions: Array<out String>) {
        requestPermissions(permissions, PERMISSIONS_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            val deniedPermission = ArrayList<String>()
            val rationalePermission = ArrayList<String>()
            for ((index, value) in grantResults.withIndex()) {
                if (value == PackageManager.PERMISSION_DENIED) {
                    if (shouldShowRequestPermissionRationale(permissions[index])) {
                        rationalePermission.add(permissions[index])
                    } else {
                        deniedPermission.add(permissions[index])
                    }
                }
            }

            if (deniedPermission.isEmpty() && rationalePermission.isEmpty()) {
                liveData.value = LivePermissionResult.Granted
            } else {
                if (rationalePermission.isNotEmpty()) {
                    liveData.value =
                        LivePermissionResult.DeniedRationale(rationalePermission.toTypedArray())
                } else if (deniedPermission.isNotEmpty()) {
                    liveData.value = LivePermissionResult.Denied(deniedPermission.toTypedArray())
                }
            }
        }
    }
}