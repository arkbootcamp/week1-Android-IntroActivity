package com.erdin.latihanandroidweek1.mvvm

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.remote.ApiClient
import com.erdin.latihanandroidweek1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var defaultSharedPref: SharedPreferences
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val service = ApiClient.getApiClient(this)?.create(AuthApiService::class.java)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.setSharedPreference(defaultSharedPref)
        if (service != null) {
            viewModel.setLoginService(service)
        }

        binding.btnLogin.setOnClickListener {
            viewModel.callLoginApi(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }

        subscribeLiveData()
    }

    private fun subscribeLiveData() {
        viewModel.isLoginLiveData.observe(this, Observer {
            Log.d("android1", "$it")

            if (it) {
                Toast.makeText(this, "Login Succcess", Toast.LENGTH_SHORT).show()
                // Intent

                // Finish Activity
                finish()
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        })

    }
}