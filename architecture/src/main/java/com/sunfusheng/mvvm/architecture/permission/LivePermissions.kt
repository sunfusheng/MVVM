package com.sunfusheng.mvvm.architecture.permission

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData

/**
 * @author sunfusheng
 * @since 2020/4/24
 */
class LivePermissions {
    companion object {
        private const val TAG = "TAG.LivePermissionsFragment"
    }

    constructor(activity: AppCompatActivity) {
        instanceLivePermissionsFragment(activity.supportFragmentManager)
    }

    constructor(fragment: Fragment) {
        instanceLivePermissionsFragment(fragment.childFragmentManager)
    }

    private lateinit var mFragment: LivePermissionsFragment

    private fun instanceLivePermissionsFragment(fragmentManager: FragmentManager) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            val fragment = LivePermissionsFragment()
            fragmentManager.beginTransaction().add(fragment, TAG).commitNow()
            mFragment = fragment
        } else {
            mFragment =
                fragmentManager.findFragmentByTag(TAG) as LivePermissionsFragment
        }
    }

    fun request(vararg permissions: String): MutableLiveData<LivePermissionResult> {
        mFragment.requestPermissions(permissions)
        return mFragment.liveData
    }
}