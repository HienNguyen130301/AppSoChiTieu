package com.example.appsochitieu.childrentFragmentHome

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.appsochitieu.R

class ThemHanMucActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_them_han_muc)

        val mbtnThemHanMuc: CardView = findViewById(R.id.cardViewThemHanMuc2)

       mbtnThemHanMuc.setOnClickListener{
            val intent = Intent(this,ThemHanMucChildrentFragment::class.java)
           startActivity(intent)
       }

    }
}