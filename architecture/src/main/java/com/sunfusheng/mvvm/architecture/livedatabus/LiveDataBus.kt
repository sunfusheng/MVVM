package com.sunfusheng.mvvm.architecture.livedatabus

/**
 * @author sunfusheng
 * @since 2020/3/7
 */
object LiveDataBus {
    private val bus = HashMap<String, BusMutableLiveData<*>>()

    @Synchronized
    fun <T> with(key: String, type: Class<T>): BusMutableLiveData<T> {
        if (!bus.containsKey(key)) {
            bus[key] = BusMutableLiveData<T>(key)
        }
        @Suppress("UNCHECKED_CAST")
        return bus[key] as BusMutableLiveData<T>
    }

    fun with(key: String): BusMutableLiveData<Any> {
        return with(key, Any::class.java)
    }

    fun getBus(): HashMap<String, BusMutableLiveData<*>> {
        return bus
    }
}