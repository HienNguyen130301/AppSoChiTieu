package com.example.appsochitieu.Fragment

import android.content.Intent
import com.example.appsochitieu.Adapter.ViewPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.appsochitieu.R
import com.example.appsochitieu.childrentFragment2.TaiKhoanFloatingButtonActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class WalletFragment : Fragment() {

    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_wallet, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Viewpager()
        floatingBtn()

    }

    private fun Viewpager() {
        tabLayout = view?.findViewById(R.id.tablayout)!!
        val viewpager2 : ViewPager2 = view?.findViewById(R.id.viewpager2)!!
        val adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)
        viewpager2.adapter = adapter
        TabLayoutMediator(tabLayout,viewpager2){tab,pos->
            when(pos){
                0->{tab.text="TÀI KHOẢN"}
                1->{tab.text="SỔ TIẾT KIỆM"}
                2->{tab.text="TÍCH LŨY"}
            }
        }.attach()
    }

    private fun floatingBtn(){
        val mbtnFloat = view?.findViewById<FloatingActionButton>(R.id.floatingBtn)
        mbtnFloat?.setOnClickListener {
            val intent = Intent(requireContext(),TaiKhoanFloatingButtonActivity::class.java)
            startActivity(intent)
        }
    }
}
