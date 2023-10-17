package com.example.appsochitieu.childrentFragment2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.appsochitieu.DataBase.DataTaiKhoan
import com.example.appsochitieu.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TaiKhoanFloatingButtonActivity : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    companion object {
        const val REQUEST_CODE_OPTIONS = 1
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tai_khoan_floating_button)

        val mbtn : CardView = findViewById(R.id.chontiente)
        val msave: ConstraintLayout = findViewById(R.id.carviewSave)
        val mbtnTienTe: CardView = findViewById(R.id.chontiente1)
        val mImgSave : ImageView = findViewById(R.id.imageViewSave)

        dbRef = FirebaseDatabase.getInstance().getReference("hemTaiKhoan")


        mImgSave.setOnClickListener {
            saveThemTaiKhoanData()
        }
        msave.setOnClickListener{
            saveThemTaiKhoanData()
        }
        mbtn.setOnClickListener{
            val intent = Intent(this, ChooseLoaiTaiKhoanActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_OPTIONS)
        } // chon loai tai khoan

        mbtnTienTe.setOnClickListener {
            val intent1 = Intent(this,ChooseLoaiTienTeActivity::class.java )
            startActivityForResult(intent1, REQUEST_CODE_OPTIONS)
        }


    }

    @SuppressLint("SuspiciousIndentation")
    private fun saveThemTaiKhoanData() {

        val mbtn1 : EditText = findViewById(R.id.empSoDuBanDau)

        val mbtn2 : EditText = findViewById(R.id.empTenTaiKhoan)
        val mbtn3: TextView = findViewById(R.id.empLoaiTaiKhoan)
        val mbtn4: TextView = findViewById(R.id.empLoaiTienTe)
        val mbtn5: EditText = findViewById(R.id.empDienGiai)



        val sodu = mbtn1.text.toString()
        val tentaikhoan = mbtn2.text.toString()
        val loaitaikhoan = mbtn3.text.toString()
        val loaitiente = mbtn4.text.toString()
        val diengiai = mbtn5.text.toString()

        val taikhoanId = dbRef.push().key!!
        val themTaiKhoan = DataTaiKhoan(taikhoanId,sodu,tentaikhoan,loaitaikhoan,loaitiente,diengiai)

        if (sodu.isEmpty() || tentaikhoan.isEmpty() || loaitaikhoan.isEmpty() || loaitiente.isEmpty() || diengiai.isEmpty()){
             Toast.makeText(this, "Please fill all the field", Toast.LENGTH_SHORT).show()
            return
        }

            dbRef.child(taikhoanId).setValue(themTaiKhoan).addOnCompleteListener{
                Toast.makeText(this, "Nhap Tai Khoan Thanh Cong",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { err ->
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_OPTIONS && resultCode == RESULT_OK) {
            val selectedOption = data?.getStringExtra("selected_option")
            if (selectedOption != null) {
                val chonTienTeTextView = findViewById<TextView>(R.id.empLoaiTaiKhoan)
                chonTienTeTextView.text = selectedOption
            }
        }

        if (requestCode == REQUEST_CODE_OPTIONS && resultCode == RESULT_OK) {
            val selectedOption = data?.getStringExtra("selected_option1")
            if (selectedOption != null) {
                val chonTienTeTextView = findViewById<TextView>(R.id.empLoaiTienTe)
                chonTienTeTextView.text = selectedOption
            }
        }
    }

}