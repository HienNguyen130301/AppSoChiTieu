package com.example.appsochitieu.Fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.appsochitieu.Adapter.TaiKhoanAdapter
import com.example.appsochitieu.R
import com.example.appsochitieu.childrentFragmentHome.NoficationHomeFragment
import com.example.appsochitieu.childrentFragmentHome.ThemHanMucActivity
import com.example.appsochitieu.childrentFragmentHome.ThemMoiActivity
import com.example.appsochitieu.childrentFragmentHome.ThuChiSettingActivity
import com.example.appsochitieu.childrentFragmentHome.TongSoDuActivity

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        gotoNofiActivity()
        dataMenu()
        showDateRangePicker()
        hideMoney()
        gotoThemHanMuc()
        gotoThemMoi()
        gotoTongSoDu()
        gointoSetting()
    }

    private fun gointoSetting(){
        val mThuchi = view?.findViewById<ImageView>(R.id.settingThuChi)
        mThuchi?.setOnClickListener {
            val intent = Intent(requireContext(), ThuChiSettingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun gotoTongSoDu() {
        val mbtn = view?.findViewById<CardView>(R.id.cardViewTongSoDu)
        mbtn?.setOnClickListener {
            val intent = Intent(requireContext(), TongSoDuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun gotoThemMoi() {
        val mThemMoi = view?.findViewById<TextView>(R.id.themmoi)
        mThemMoi?.setOnClickListener {
            val intent = Intent(requireContext(), ThemMoiActivity::class.java)
            startActivity(intent)
        }
    }

    private fun gotoThemHanMuc() {
        val mThemHanMuc = view?.findViewById<TextView>(R.id.themhanmuc)
        mThemHanMuc?.setOnClickListener {
            val intent = Intent(requireContext(), ThemHanMucActivity::class.java)
            startActivity(intent)
        }
    }

    private fun gotoNofiActivity() {
        val imageView = view?.findViewById<ImageView>(R.id.nofication_fragmenthome)
        imageView?.setOnClickListener {
            val intent = Intent(requireContext(), NoficationHomeFragment::class.java)
            startActivity(intent)
        }
    }

    private fun hideMoney() {
        val selectedDateRangeTextView = view?.findViewById<TextView>(R.id.totalMoney)
        val hideTextButton = view?.findViewById<ImageView>(R.id.eyeshide)

        var isTextHidden = false

        hideTextButton?.setOnClickListener {
            if (isTextHidden) {
                // If the text is currently hidden, restore the original text
                selectedDateRangeTextView?.text = "1.000.000.000 $"
                isTextHidden = false
                // Change the ImageView source to the "hide" icon
                hideTextButton.setImageResource(R.drawable.eye24)
            } else {
                // If the text is not hidden, replace it with asterisks
                selectedDateRangeTextView?.text = "*******"
                isTextHidden = true
                // Change the ImageView source to the "show" icon
                hideTextButton.setImageResource(R.drawable.baseline_visibility_off_24)
            }
        }
    }

    private fun showDateRangePicker() {
        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.date_range_picker_layout, null)
        val startDatePicker = dialogView.findViewById<DatePicker>(R.id.start_date_picker)
        val endDatePicker = dialogView.findViewById<DatePicker>(R.id.end_date_picker)
        var pickDateButton = view?.findViewById<TextView>(R.id.timepicker)
        pickDateButton?.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext())
                .setView(dialogView)
                .setTitle("Select Date Range")
                .setPositiveButton("Confirm") { _, _ ->
                    // Handle the selected start and end dates here
                    val startYear = startDatePicker.year
                    val startMonth = startDatePicker.month
                    val startDay = startDatePicker.dayOfMonth
                    val endYear = endDatePicker.year
                    val endMonth = endDatePicker.month
                    val endDay = endDatePicker.dayOfMonth

                    val selectedStartDate = "$startDay/${startMonth + 1}/$startYear"
                    val selectedEndDate = "$endDay/${endMonth + 1}/$endYear"

                    pickDateButton?.text = "$selectedStartDate - $selectedEndDate"
                    // Now you can use selectedStartDate and selectedEndDate as needed
                }
                .setNegativeButton("Cancel", null)
                .create()

            dialog.show()
        }
    }

    private fun dataMenu() {
        val list = resources.getStringArray(R.array.DateMenu)
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, list)

        val spinner: Spinner = requireView().findViewById(R.id.spinner)

        spinner.adapter = adapter
    }
}