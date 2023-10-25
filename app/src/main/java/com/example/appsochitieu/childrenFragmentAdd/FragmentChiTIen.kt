package com.example.appsochitieu.childrenFragmentAdd

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.appsochitieu.R
import com.google.firebase.FirebaseApp

class FragmentChiTIen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_chi_t_ien, container, false)
        FirebaseApp.initializeApp(requireContext());
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gotoChonVi()
    }

        private fun gotoChonVi() {
        val mChonVibtn = view?.findViewById<CardView>(R.id.chooseVi)
        mChonVibtn?.setOnClickListener {
            val intent = Intent(requireContext(), ChonViActivity::class.java)
            startActivity(intent)
        }
    }

}
