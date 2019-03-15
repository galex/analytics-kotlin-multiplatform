package com.analytics.analyticsapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val FRAGMENT_TAG = "FRAGMENT_TAG"
    }


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val fragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)
                if(fragment !is HomeFragment) {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, HomeFragment.newInstance(), FRAGMENT_TAG)
                            .commitNow()
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val fragment = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG)
                if(fragment !is DashboardFragment) {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, DashboardFragment.newInstance(), FRAGMENT_TAG)
                            .commitNow()
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navView.selectedItemId = R.id.navigation_home
    }
}
