package com.example.appsochitieu.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.appsochitieu.Adapter.CustomSpinnerAdapter
import com.example.appsochitieu.DataBase.DataCustomSpinner
import com.example.appsochitieu.childrenFragmentAdd.FragmentChiTIen
import com.example.appsochitieu.childrenFragmentAdd.FragmentChoVay
import com.example.appsochitieu.childrenFragmentAdd.FragmentThuTien
import com.example.appsochitieu.R

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customSpinner()
    }

    private fun customSpinner() {
        val customSpinner12 = view?.findViewById<Spinner>(R.id.customSpinner1)
        val list2 = mutableListOf<DataCustomSpinner>()
        list2.add(DataCustomSpinner(R.drawable.travel_explore_24, "Chi Tiền 1"))
        list2.add(DataCustomSpinner(R.drawable.travel_explore_24, "Chi Tiền 2"))
        list2.add(DataCustomSpinner(R.drawable.travel_explore_24, "Chi Tiền 3"))
        list2.add(DataCustomSpinner(R.drawable.travel_explore_24, "Chi Tiền 4"))
        list2.add(DataCustomSpinner(R.drawable.travel_explore_24, "Chi Tiền 5"))
        list2.add(DataCustomSpinner(R.drawable.travel_explore_24, "Chi Tiền 6"))

        val customSpinner1 = CustomSpinnerAdapter(this@AddFragment, list2)
        customSpinner12?.adapter = customSpinner1

        customSpinner12?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                fun replaceFragment(fragment: Fragment) {
                    // Use a FragmentTransaction to replace the current fragment with the destination fragment
                    val transaction = parentFragmentManager.beginTransaction()
                    transaction.replace(R.id.fl2, fragment)
                    transaction.addToBackStack(null) // Add the transaction to the back stack (optional)
                    transaction.commit()
                }

                replaceFragment(FragmentChiTIen())
                when (p2) {
                    0 -> replaceFragment(FragmentChiTIen())
                    1 -> replaceFragment(FragmentThuTien())
                    2 -> replaceFragment(FragmentChoVay())
                }
            }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
    }

