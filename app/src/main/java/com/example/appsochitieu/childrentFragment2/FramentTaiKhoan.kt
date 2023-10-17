package com.example.appsochitieu.childrentFragment2

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



    private fun GetThongTinTaiKhoan() {
        dbRef = FirebaseDatabase.getInstance().getReference("hemTaiKhoan")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                ds.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(DataTaiKhoan::class.java)
                        ds.add(empData!!)
                    }
                    val mAdapter = TaiKhoanAdapter(ds)
                    recyclerView.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}
