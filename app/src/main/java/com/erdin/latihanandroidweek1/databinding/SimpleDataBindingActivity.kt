package com.erdin.latihanandroidweek1.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.erdin.latihanandroidweek1.R

class SimpleDataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple_data_binding)


        binding.model = ArkademyModel("Wahyu Kurniawan", "Jakarta", "wahyu@gmail.com")
        binding.btnChange.setOnClickListener {
            binding.model = ArkademyModel("Muhammad Rizki", "Bandung", "rizki@gmail.com")
        }
    }
}