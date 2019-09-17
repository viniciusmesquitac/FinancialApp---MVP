package com.example.financialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.financialapp.Adapter.PageAdapter
import com.example.financialapp.Fragments.HomeFragment
import com.example.financialapp.Fragments.InsightFragment
import com.example.financialapp.Presenter.InterfaceLoginPresenter
import com.example.financialapp.Presenter.LoginPresenter
import com.example.financialapp.View.ILoginView
import com.example.financialapp.View.NavigationBottomView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), ILoginView {

    override fun onLoginResult(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal lateinit var loginPresenter: InterfaceLoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        // MARK: INIT PRESENTER
        loginPresenter = LoginPresenter(this)

        // MARK: SETUP NAVIGATION BOTTOM VIEW - SUPPORT FRAGMENT MANAGER

        val navigationView = NavigationBottomView()

        val mOnNavigationItemSelectedListener = navigationView.navigationActionListener(supportFragmentManager)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.btnAdd -> {
            val intent = Intent(this, InsertExpensesActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            true
        }
        R.id.logout -> {
            loginPresenter.onLogout(this)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
