package com.sunfusheng.mvvm.extension

import android.app.Activity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author sunfusheng
 * @since 2020/4/8
 */
inline fun <reified T> Activity.args(): ReadWriteProperty<Activity, T> = bundleDelegate {
  val bundle: Bundle =
    (if (intent == null || intent.extras == null) Bundle() else intent.extras) as Bundle
  bundle
}

inline fun <reified T> Fragment.args(): ReadWriteProperty<Fragment, T> = bundleDelegate {
  if (arguments == null) arguments = Bundle()
  requireArguments()
}

inline fun <F, reified T> bundleDelegate(crossinline bundleProvider: (F) -> Bundle): ReadWriteProperty<F, T> =
  object : ReadWriteProperty<F, T> {
    override operator fun getValue(thisRef: F, property: KProperty<*>): T =
      bundleProvider(thisRef).get(property.name) as T

    override fun setValue(thisRef: F, property: KProperty<*>, value: T) =
      bundleProvider(thisRef).putAll(bundleOf(property.name to value))
  }