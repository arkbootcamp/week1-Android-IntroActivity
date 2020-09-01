package com.erdin.latihanandroidweek1.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.erdin.latihanandroidweek1.R

class SimpleFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_fragment)

        val btnSwitchA = findViewById<Button>(R.id.btn_switch_a)
        val btnSwitchB = findViewById<Button>(R.id.btn_switch_b)

        btnSwitchA.setOnClickListener {
            val aFragment = FragmentA()
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, aFragment).commit()
        }

        btnSwitchB.setOnClickListener {
            val bFragment = FragmentB()
            supportFragmentManager.beginTransaction().replace(R.id.fl_container, bFragment).commit()
        }

    }
}