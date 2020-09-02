package com.erdin.latihanandroidweek1.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.erdin.latihanandroidweek1.R

class SimpleFragmentActivity : AppCompatActivity(), FragmentA.AListener {

    private lateinit var txtInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_fragment)

        val btnSwitchA = findViewById<Button>(R.id.btn_switch_a)
        val btnSwitchB = findViewById<Button>(R.id.btn_switch_b)
        txtInfo = findViewById(R.id.tv_info_fragment)

        // Activity to Fragment
        btnSwitchA.setOnClickListener {
            val aFragment = FragmentA(this)
            val bundle = Bundle()
            bundle.putString(FragmentA.EXTRA_INFO, "ARGUMENT A")
            aFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, aFragment).commit()
        }

        // Passing data Fragment to Activity
        btnSwitchB.setOnClickListener {
            val bFragment = FragmentB(object : FragmentB.BListener {
                override fun onChangeBClick(info: String) {
                    txtInfo.text = info
                }

            })
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, bFragment).commit()
        }

    }

    override fun onChangeAClicked() {
        txtInfo.text = "A"
    }


}