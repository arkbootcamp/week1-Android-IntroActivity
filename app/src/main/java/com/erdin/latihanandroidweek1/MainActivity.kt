package com.erdin.latihanandroidweek1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnActivityA = findViewById<Button>(R.id.btn_to_activity_a)
        val btnActivityB = findViewById<Button>(R.id.btn_to_activity_b)

        val intentA = Intent(this, OneActivity::class.java)
        val intentB = Intent(this, TwoActivity::class.java)

        btnActivityA.setOnClickListener {
            startActivity(intentA)
        }

        btnActivityB.setOnClickListener {
            startActivity(intentB)
        }


    }
}