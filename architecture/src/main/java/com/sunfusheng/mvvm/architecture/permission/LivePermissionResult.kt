package com.sunfusheng.mvvm.architecture.permission

/**
 * @author sunfusheng
 * @since 2020/4/24
 */
sealed class LivePermissionResult {
    // 已授权
    object Granted : LivePermissionResult()

    // 没有被授权，且勾选了「不再询问」
    class Denied(val permissions: Array<String>) : LivePermissionResult()

    //  没有被授权，没有勾选「不再询问」
    class DeniedRationale(val permissions: Array<String>) : LivePermissionResult()
}