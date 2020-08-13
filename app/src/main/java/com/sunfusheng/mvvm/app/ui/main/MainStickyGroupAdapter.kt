package com.sunfusheng.mvvm.app.ui.main

import android.content.Context
import com.sunfusheng.GroupViewHolder
import com.sunfusheng.HeaderGroupRecyclerViewAdapter
import com.sunfusheng.mvvm.app.R

/**
 * @author sunfusheng
 * @since 2020/3/29
 */
class MainStickyGroupAdapter(context: Context?, groups: List<List<MainItem>>) :
    HeaderGroupRecyclerViewAdapter<MainItem>(context, groups) {

    override fun getHeaderLayoutId(viewType: Int): Int {
        return R.layout.layout_group_header
    }

    override fun getChildLayoutId(viewType: Int): Int {
        return R.layout.layout_group_child
    }

    override fun onBindHeaderViewHolder(
        holder: GroupViewHolder,
        item: MainItem,
        groupPosition: Int
    ) {
        holder.setText(R.id.vHeader, item.title)
    }

    override fun onBindChildViewHolder(
        holder: GroupViewHolder,
        item: MainItem,
        groupPosition: Int,
        childPosition: Int
    ) {
        holder.setText(R.id.vChild, item.title)
        holder.setVisible(R.id.vDivider, !isGroupLastItem(groupPosition, childPosition))
    }
}