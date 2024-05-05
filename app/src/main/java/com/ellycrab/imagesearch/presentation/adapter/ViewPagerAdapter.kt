package com.ellycrab.imagesearch.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ellycrab.imagesearch.presentation.search.fragments.SaveFragment
import com.ellycrab.imagesearch.presentation.search.fragments.SearchFragment
import java.lang.IllegalStateException

class ViewPagerAdapter(activity: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(activity,
    lifecycle) {

    private val TAB_COUNT = 2

    override fun getItemCount(): Int {
        return TAB_COUNT // 탭의 총 개수
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->SearchFragment()
            1-> SaveFragment()
            else -> throw IllegalStateException("Unexpected position ${position}")
        }
    }




}