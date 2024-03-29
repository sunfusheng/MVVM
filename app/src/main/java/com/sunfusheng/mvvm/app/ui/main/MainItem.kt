package com.sunfusheng.mvvm.app.ui.main

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
@MainGroupDslMarker
data class MainItem(
  var title: String,
  var clazz: Class<*>? = null
)

@DslMarker
annotation class MainGroupDslMarker

@DslMarker
annotation class MainGroupDataSourceDslMarker

@MainGroupDslMarker
@MainGroupDataSourceDslMarker
abstract class AbsMainGroup() {
  val list = ArrayList<MainItem>()

  private fun <T : AbsMainGroup> addItem(group: T, init: MainItem.() -> Unit) {
    if (group.list.isEmpty()) {
      group.list.add(MainItem(getTitle()))
    }
    group.list.add(MainItem(getTitle()).apply(init))
  }

  protected abstract fun getTitle(): String

  fun item(init: MainItem.() -> Unit) = addItem(this, init)
}

open class NavigationGroup : AbsMainGroup() {
  override fun getTitle() = "Navigation"
}

open class DataBindingGroup : AbsMainGroup() {
  override fun getTitle() = "DataBinding"
}

open class MotionLayoutGroup : AbsMainGroup() {
  override fun getTitle() = "MotionLayout"
}

@MainGroupDataSourceDslMarker
open class MainGroupDataSource {
  open val lists = ArrayList<ArrayList<MainItem>>()

  fun navigationGroup(init: NavigationGroup.() -> Unit) {
    lists.add(NavigationGroup().apply(init).list)
  }

  fun databindingGroup(init: DataBindingGroup.() -> Unit) {
    lists.add(DataBindingGroup().apply(init).list)
  }

  fun motionLayoutGroup(init: MotionLayoutGroup.() -> Unit) {
    lists.add(MotionLayoutGroup().apply(init).list)
  }
}

fun mainGroupDataSource(init: MainGroupDataSource.() -> Unit): ArrayList<ArrayList<MainItem>> {
  return MainGroupDataSource().apply(init).lists
}