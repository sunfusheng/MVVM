package com.sunfusheng.mvvm.architecture.bus

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author sunfusheng
 * @since 2020/3/7
 */
open class BusMutableLiveData<T>(private val key: String) : MutableLiveData<T>() {
    private val observerMap = HashMap<Observer<in T>, Observer<in T>>()
    private val mainHandler = Handler(Looper.getMainLooper())

    override fun postValue(value: T) {
        mainHandler.post { setValue(value) }
    }

    override fun setValue(value: T) {
        super.setValue(value)
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)
        hook(observer)
    }

    override fun observeForever(observer: Observer<in T>) {
        if (!observerMap.containsKey(observer)) {
            observerMap[observer] = BusObserverWrapper(observer)
        }
        super.observeForever(observerMap[observer]!!)
    }

    override fun removeObserver(observer: Observer<in T>) {
        var realObserver: Observer<in T>? = null
        if (observerMap.containsKey(observer)) {
            realObserver = observerMap.remove(observer)
        }
        if (realObserver == null) {
            realObserver = observer
        }
        super.removeObserver(realObserver)
        if (!hasObservers()) {
            LiveDataBus.getBus().remove(key)
        }
    }

    private fun hook(observer: Observer<in T>) {
        try {
            val classLiveData = LiveData::class.java
            val fieldObservers = classLiveData.getDeclaredField("mObservers")
            fieldObservers.isAccessible = true
            val objectObservers = fieldObservers[this]
            val classObservers: Class<*> = objectObservers.javaClass
            val methodGet = classObservers.getDeclaredMethod("get", Any::class.java)
            methodGet.isAccessible = true
            val objectWrapperEntry = methodGet.invoke(objectObservers, observer)
            var objectWrapper: Any? = null
            if (objectWrapperEntry is Map.Entry<*, *>) {
                objectWrapper = objectWrapperEntry.value
            }
            if (objectWrapper == null) {
                throw NullPointerException("ObserverWrapper can not be null!")
            }

            val classObserverWrapper: Class<*>? = objectWrapper.javaClass.superclass
            if (classObserverWrapper != null) {
                val fieldObserverWrapperLastVersion =
                    classObserverWrapper.getDeclaredField("mLastVersion")
                fieldObserverWrapperLastVersion.isAccessible = true
                val fieldLiveDataVersion = classLiveData.getDeclaredField("mVersion")
                fieldLiveDataVersion.isAccessible = true
                val objectVersion = fieldLiveDataVersion.get(this)
                fieldObserverWrapperLastVersion.set(objectWrapper, objectVersion)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

internal class BusObserverWrapper<T>(private val observer: Observer<T>?) : Observer<T> {

    override fun onChanged(t: T?) {
        if (isCallOnObserve()) {
            return
        }

        try {
            observer?.onChanged(t)
        } catch (e: ClassCastException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun isCallOnObserve(): Boolean {
        try {
            val stackTrace = Thread.currentThread().stackTrace
            if (stackTrace.isNotEmpty()) {
                for (element in stackTrace) {
                    if ("android.arch.lifecycle.LiveData" == element.className && "observeForever" == element.methodName) {
                        return true
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}