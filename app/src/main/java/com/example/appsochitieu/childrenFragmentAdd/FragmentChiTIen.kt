package com.example.appsochitieu.childrenFragmentAdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appsochitieu.R

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentChiTIen.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentChiTIen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi_t_ien, container, false)
    }
}