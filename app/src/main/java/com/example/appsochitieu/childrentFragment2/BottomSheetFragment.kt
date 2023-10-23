package com.example.appsochitieu.childrentFragment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.appsochitieu.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        val textViewOption1 = view.findViewById<CardView>(R.id.sapxep1)
        val textViewOption2 = view.findViewById<CardView>(R.id.sapxep2)

        textViewOption1.setOnClickListener {
            // Handle the option 1 click
            dismiss()
        }

        textViewOption2.setOnClickListener {
            // Handle the option 2 click
            dismiss()
        }
        return view
    }
}
