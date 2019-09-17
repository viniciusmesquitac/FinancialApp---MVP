@file:Suppress("DEPRECATION")

package com.example.financialapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.financialapp.Fragments.HomeFragment
import com.example.financialapp.Fragments.InsightFragment
import com.example.financialapp.Fragments.OrganizationFragment

class PageAdapter (fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager)  {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> OrganizationFragment()
            else -> InsightFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "1"
            1 -> "2"
            else -> "3"
        }
    }

}