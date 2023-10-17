package com.example.appsochitieu.childrentFragment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.appsochitieu.R

class ChooseLoaiTienTeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_loai_tien_te)

        val option1 = findViewById<TextView>(R.id.option1Text1)
        option1.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option1", option1.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option2 = findViewById<TextView>(R.id.option1Text2)
        option2.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option1", option2.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option3 = findViewById<TextView>(R.id.option1Text3)
        option3.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option1", option3.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option4 = findViewById<TextView>(R.id.option1Text4)
        option4.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option1", option4.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}