package com.example.appsochitieu.Adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.appsochitieu.DataBase.DataCustomSpinner
import com.example.appsochitieu.R

class CustomSpinnerAdapter(val activity: Fragment, val list2: List<DataCustomSpinner>) : ArrayAdapter<DataCustomSpinner>(activity.requireContext(),
    R.layout.frament_add_list_item) {
    override fun getCount(): Int {
        return list2.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return innitView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return innitView(position, convertView, parent)
    }

    private fun innitView(position: Int, convertView: View?,parent: ViewGroup): View{
        val context = activity.layoutInflater
        val rowView = context.inflate(R.layout.frament_add_list_item,parent,false)

        val images = rowView.findViewById<ImageView>(R.id.imageSpinner)
        val title = rowView.findViewById<TextView>(R.id.textviewSpinner)

        images.setImageResource(list2[position].img)
        title.text = list2[position].descrise
        return rowView

    }
}