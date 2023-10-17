package com.example.appsochitieu

import com.example.appsochitieu.Fragment.WalletFragment
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.appsochitieu.Fragment.AddFragment
import com.example.appsochitieu.Fragment.ChartFragment
import com.example.appsochitieu.Fragment.HomeFragment
import com.example.appsochitieu.Fragment.MoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mBottomView: BottomNavigationView = findViewById(R.id.BottomNavView)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        replaceFragment(HomeFragment())

        mBottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.wallet -> replaceFragment(WalletFragment())
                R.id.chart -> replaceFragment(ChartFragment())
                R.id.more -> replaceFragment(MoreFragment())
                R.id.placeholder -> replaceFragment(AddFragment())


                else -> {

                }
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTrans = fragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fl1, fragment)
        fragmentTrans.commit()
    }

}