package com.example.financialapp.View

import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.financialapp.Fragments.HomeFragment
import com.example.financialapp.Fragments.InsightFragment
import com.example.financialapp.Fragments.OrganizationFragment
import com.example.financialapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationBottomView: IHomeView {

    private var content: FrameLayout? = null


    override fun addFragment(fragment: Fragment, supportFragmentManager: FragmentManager) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun navigationActionListener(supportFragmentManager: FragmentManager): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_call -> {
                    val fragment = HomeFragment()
                    addFragment(fragment, supportFragmentManager)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_search -> {
                    val fragment = OrganizationFragment()
                    addFragment(fragment, supportFragmentManager)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_insight -> {
                    val fragment = InsightFragment()
                    addFragment(fragment, supportFragmentManager)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    }
}