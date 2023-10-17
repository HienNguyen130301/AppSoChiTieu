package com.example.appsochitieu.childrentFragmentHome

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.appsochitieu.Fragment.HomeFragment
import com.example.appsochitieu.R

class NoficationHomeFragment : AppCompatActivity() {
    private lateinit var mbtnBack : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nofication_home_fragment)

        mbtnBack = findViewById(R.id.comeback)

        mbtnBack.setOnClickListener{
            val nofiFragment = HomeFragment()
            val fragment: Fragment? = supportFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
            if (fragment !is HomeFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_home, nofiFragment,HomeFragment::class.java.simpleName)
                    .commit()
            }
        } //dang bi loi

    }
}