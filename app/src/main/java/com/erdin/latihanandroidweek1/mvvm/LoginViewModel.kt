package com.erdin.latihanandroidweek1.mvvm

import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erdin.latihanandroidweek1.sharedpref.LearnSharedPrefActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LoginViewModel : ViewModel(), CoroutineScope {

    val isLoginLiveData = MutableLiveData<Boolean>()

    private lateinit var service: AuthApiService
    private lateinit var sharedPreferences: SharedPreferences

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    fun setSharedPreference(sharedPreferences: SharedPreferences) {
        this.sharedPreferences = sharedPreferences
    }

    fun setLoginService(service: AuthApiService) {
        this.service = service
    }

    fun callLoginApi(email: String, password: String) {
        launch {

            val response = withContext(Dispatchers.IO) {
                try {
                    service?.loginRequest(email, password)
                } catch (e: Throwable) {
                    e.printStackTrace()

                    withContext(Dispatchers.Main) {
                        isLoginLiveData.value = false
                    }

                }
            }

            if (response is LoginResponse) {
                if (response.data?.role == "1") {
                    // SAVE TOKEN TO SHARED PREF
                    sharedPreferences.edit().putString(LearnSharedPrefActivity.KEY_TOKEN, response.data.token).apply()
                    // SAVE LOGIN DATA SHARED PREF

                    isLoginLiveData.value = true
                } else {
                    isLoginLiveData.value = false
                }
            }
        }
    }
}