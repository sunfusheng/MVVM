package com.sunfusheng.mvvm.architecture.app.ui.main

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

@MainGroupDataSourceDslMarker
open class MainGroupDataSource {
    open val lists = ArrayList<ArrayList<MainItem>>()

    fun navigationGroup(init: NavigationGroup.() -> Unit) {
        lists.add(NavigationGroup().apply(init).list)
    }
}

fun mainGroupDataSource(init: MainGroupDataSource.() -> Unit): ArrayList<ArrayList<MainItem>> {
    return MainGroupDataSource().apply(init).lists
}