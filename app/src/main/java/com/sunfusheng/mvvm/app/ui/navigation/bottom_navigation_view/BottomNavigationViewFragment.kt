package com.sunfusheng.mvvm.app.ui.navigation.bottom_navigation_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.sunfusheng.mvvm.app.BR
import com.sunfusheng.mvvm.app.R
import com.sunfusheng.mvvm.app.databinding.FragmentBottomNavigationViewBinding
import com.sunfusheng.mvvm.base.BaseDBVMFragment
import com.sunfusheng.mvvm.extension.gone
import com.sunfusheng.mvvm.extension.visible
import com.sunfusheng.mvvm.viewmodel.BaseViewModel
import com.sunfusheng.mvvm.viewmodel.getViewModel

class BottomNavigationViewFragment :
    BaseDBVMFragment<FragmentBottomNavigationViewBinding, BaseViewModel>() {

    private val fragments = arrayListOf<Pair<Int, Fragment>>()
    private val homeFragment by lazy { R.string.tab_home to HomeFragment() }
    private val exploreFragment by lazy { R.string.tab_explore to ExploreFragment() }
    private val userFragment by lazy { R.string.tab_user to UserFragment() }

    init {
        fragments.run {
            add(homeFragment)
            add(exploreFragment)
            add(userFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
        initBottomNavigationView()
        switchFragment(0)
    }

    private fun initViewPager() {
        binding.vViewPager2.isUserInputEnabled = false
        binding.vViewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int) = fragments[position].second
        }
    }

    private fun initBottomNavigationView() {
        setUnreadCount(6)

        binding.vBottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_item_home -> switchFragment(0)
                R.id.menu_item_explore -> switchFragment(1)
                R.id.menu_item_user -> switchFragment(2)
            }
            true
        }
    }

    private fun switchFragment(position: Int) {
        requireActivity().setTitle(fragments[position].first)
        binding.vViewPager2.setCurrentItem(position, false)
    }

    private fun setUnreadCount(count: Int) {
        val menuView: BottomNavigationMenuView =
            binding.vBottomNavigationView.getChildAt(0) as BottomNavigationMenuView
        val itemView: BottomNavigationItemView =
            menuView.getChildAt(1) as BottomNavigationItemView
        val vBadgeView: View =
            LayoutInflater.from(context).inflate(R.layout.layout_badge_view, menuView, false)
        itemView.addView(vBadgeView)
        val vUnreadCount: TextView = vBadgeView.findViewById(R.id.tv_count)
        if (count <= 0) {
            vUnreadCount.gone()
        } else {
            vUnreadCount.visible()
            vUnreadCount.text = String.format("%s", if (count > 99) 99 else count)
        }
    }

    override fun getLayoutId() = R.layout.fragment_bottom_navigation_view

    override fun createViewModel(): BaseViewModel = getViewModel()

    override fun getVariableId() = BR.viewModel
}
