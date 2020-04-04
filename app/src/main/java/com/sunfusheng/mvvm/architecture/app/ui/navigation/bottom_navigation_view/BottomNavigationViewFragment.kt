package com.sunfusheng.mvvm.architecture.app.ui.navigation.bottom_navigation_view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunfusheng.mvvm.architecture.app.R
import kotlinx.android.synthetic.main.fragment_bottom_navigation_view.*

class BottomNavigationViewFragment : Fragment(R.layout.fragment_bottom_navigation_view) {

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
        vViewPager2.isUserInputEnabled = false
        vViewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int) = fragments[position].second
        }
    }

    private fun initBottomNavigationView() {
        vBottomNavigationView.setOnNavigationItemSelectedListener {
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
        vViewPager2.setCurrentItem(position, false)
    }
}
