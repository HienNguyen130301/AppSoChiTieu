package com.example.appsochitieu.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appsochitieu.R
import com.example.appsochitieu.DataBase.DataTaiKhoan

class TaiKhoanAdapter(private val items: ArrayList<DataTaiKhoan>) :
    RecyclerView.Adapter<TaiKhoanAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.txt1)
        val textView2: TextView = itemView.findViewById(R.id.txt2)
        val imgview: ImageView = itemView.findViewById(R.id.imageView2)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.themtaikhoan_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]

        holder.textView.text = currentItem.sodu
        holder.textView2.text = currentItem.tentaikhoan
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun calculateTotalSodu(): Double {
        var totalSodu = 0.0
        for (item in items) {
            totalSodu += item.sodu!!.toDouble()
            if (item.sodu == null) {
                Log.d("Hienzd", "null roi nhe")
            } else {
                totalSodu += item.sodu!!.toDouble()
                Log.d("Hienzd", "${item.sodu}")
            }
        }
        return totalSodu
    }



}
