package com.example.appsochitieu.childrenFragmentAdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appsochitieu.Adapter.TaiKhoanAdapter
import com.example.appsochitieu.DataBase.DataTaiKhoan
import com.example.appsochitieu.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChonViActivity : AppCompatActivity() {

    private lateinit var ds: ArrayList<DataTaiKhoan>
    private lateinit var recyclerView: RecyclerView
    private lateinit var dbRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chon_vi)

        recyclerView = findViewById(R.id.fl4)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        ds = arrayListOf<DataTaiKhoan>()

        GetThongTinTK()

    }

    private fun GetThongTinTK() {
        dbRef = FirebaseDatabase.getInstance().getReference("hemTaiKhoan")
        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                if (snapshot.exists()){
                    for(empSnap in snapshot.children){
                        val empData = empSnap.getValue(DataTaiKhoan::class.java)
                        ds.add(empData!!)
                    }
                    val mAdapter = TaiKhoanAdapter(ds)
                    recyclerView.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}