package com.example.appsochitieu.childrentFragment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Slide
import androidx.transition.TransitionManager

import com.example.appsochitieu.Adapter.TaiKhoanAdapter
import com.example.appsochitieu.DataBase.DataTaiKhoan
import com.example.appsochitieu.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.text.DecimalFormat

class FramentTaiKhoan : Fragment() {

    private lateinit var ds: ArrayList<DataTaiKhoan>
    private lateinit var dbRef: DatabaseReference
    private lateinit var recyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_frament_tai_khoan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val cardviewDropOut = view.findViewById<CardView>(R.id.cardviewDropOut)
         recyclerView = view.findViewById(R.id.recyclerView)
        val transition = Slide(Gravity.START)  // Create a transition (you can use other types like Slide, Fade, etc.)
        transition.duration = 200

        cardviewDropOut.setOnClickListener {
            // Toggle the visibility of the RecyclerView with transition
            TransitionManager.beginDelayedTransition(view as ViewGroup, transition)
            recyclerView.visibility = if (recyclerView.visibility == View.GONE) View.VISIBLE else View.GONE
        }


        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        ds = arrayListOf<DataTaiKhoan>()
        GetThongTinTaiKhoan()


    }

    fun formatNumber(number: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        return decimalFormat.format(number)
    }

    private fun GetThongTinTaiKhoan() {
        dbRef = FirebaseDatabase.getInstance().getReference("hemTaiKhoan")
        dbRef.addValueEventListener(object : ValueEventListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DataTaiKhoan::class.java)
                        ds.add(empData!!)
                    }
                    val mAdapter = TaiKhoanAdapter(ds)
                    recyclerView.adapter = mAdapter

                    val mtotal = view?.findViewById<TextView>(R.id.totalMn)
                    val mtotal2 = view?.findViewById<TextView>(R.id.totalMn2)

                    mAdapter.notifyDataSetChanged() // Notify the adapter of data changes
                    val totalSodu = mAdapter.calculateTotalSodu() // Calculate total sodu using the adapter
                    val fomartNumber = formatNumber(totalSodu)
                    mtotal?.text = "Đang sử dụng ($fomartNumber đ)"
                    mtotal2?.text = "Tổng tiền: $fomartNumber đ"

                    val database = Firebase.database
                    val myRef = database.getReference("Total Money")
                    myRef.setValue(totalSodu)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}
