package com.example.appsochitieu.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.appsochitieu.childrentFragment2.FragmentTichLuy
import com.example.appsochitieu.childrentFragment2.FramentSoTietKiem
import com.example.appsochitieu.childrentFragment2.FramentTaiKhoan

class ViewPagerAdapter(fragment: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragment,lifecycle)  {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                FramentTaiKhoan()
            }
            0->{
                FramentSoTietKiem()
            }
            else -> {
                FragmentTichLuy()
            }
        }
    }


}
