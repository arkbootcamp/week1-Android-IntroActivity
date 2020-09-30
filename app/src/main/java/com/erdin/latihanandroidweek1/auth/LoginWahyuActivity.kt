package com.erdin.latihanandroidweek1.auth

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.preference.PreferenceManager
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.ActivityLoginWahyuBinding
import com.erdin.latihanandroidweek1.sharedpref.LearnSharedPrefActivity
import kotlinx.coroutines.*

class LoginWahyuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginWahyuBinding
    private lateinit var defaultSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_wahyu)
        defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)
        binding.btnLogin.setOnClickListener {
            callAuthApi()
        }
    }

    private fun callAuthApi() {
        val service = ApiClient.getApiClient(this)?.create(AuthApiService::class.java)

        val coroutineScope = CoroutineScope(Job() + Dispatchers.Main )

        coroutineScope.launch {
            Log.d("android1", "start : ${Thread.currentThread().name}")

            val response = withContext(Dispatchers.IO) {
                Log.d("android1", "callApi : ${Thread.currentThread().name}")

                try {
                    service?.loginRequest(binding.etEmail.text.toString(), binding.etPassword.text.toString())
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (response is LoginResponse) {
                if (response.data?.role == "admin") {
                    // SAVE TOKEN TO SHARED PREF
                    defaultSharedPref.edit().putString(LearnSharedPrefActivity.KEY_TOKEN, response.data.token).apply()
                    // SAVE LOGIN DATA SHARED PREF

                    //Toast login berhasil
                    Toast.makeText(this@LoginWahyuActivity, "Login Sukses", Toast.LENGTH_SHORT).show()

                    // Intent to Another Activity

                } else {
                    Toast.makeText(this@LoginWahyuActivity, response.message, Toast.LENGTH_SHORT).show()
                }
                Log.d("android1", response.toString())
            }


        }
    }
}