package com.erdin.latihanandroidweek1.tabpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.erdin.latihanandroidweek1.fragment.FragmentA
import com.erdin.latihanandroidweek1.fragment.FragmentB

class SimpleTabPagerAdapter(fragment: FragmentManager) : FragmentStatePagerAdapter(fragment, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragment = arrayOf(FragmentA(null), FragmentB(null))

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getCount(): Int = fragment.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Fragment A"
            1 -> "Fragment B"
            else -> ""
        }
    }
}