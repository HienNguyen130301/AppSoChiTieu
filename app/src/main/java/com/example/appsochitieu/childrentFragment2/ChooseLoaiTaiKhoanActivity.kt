package com.example.appsochitieu.childrentFragment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.appsochitieu.R

class ChooseLoaiTaiKhoanActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_loai_tai_khoan)



        val option1 = findViewById<TextView>(R.id.option1Text)
        option1.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option", option1.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option2 = findViewById<TextView>(R.id.option2Text)
        option2.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option", option2.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option3 = findViewById<TextView>(R.id.option3Text)
        option3.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option", option3.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option4 = findViewById<TextView>(R.id.option4Text)
        option4.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option", option4.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option5 = findViewById<TextView>(R.id.option5Text)
        option5.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option", option5.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        val option6 = findViewById<TextView>(R.id.option6Text)
        option6.setOnClickListener {
            // Set the selected option as the result and finish the activity
            val resultIntent = Intent()
            resultIntent.putExtra("selected_option", option6.text.toString())
            setResult(RESULT_OK, resultIntent)
            finish()
        }

    }

}