package com.erdin.latihanandroidweek1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        val tvDomain = findViewById<TextView>(R.id.tv_domain_name)

        val domainName = intent.getStringExtra("domainName")
        tvDomain.text = domainName
        Log.d("domainString", domainName)

    }
}