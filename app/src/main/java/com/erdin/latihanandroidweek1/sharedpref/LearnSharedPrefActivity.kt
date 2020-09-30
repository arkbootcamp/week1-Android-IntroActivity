package com.erdin.latihanandroidweek1.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.databinding.DataBindingUtil
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.ActivityLearnSharedPrefBinding

class LearnSharedPrefActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnSharedPrefBinding

    companion object {
        const val SHARED_PREFERENCES_NAME = "LearnSharedPref"
        const val KEY_EMAIL = "KEY_EMAIL"
        const val KEY_TOKEN = "KEY_TOKEN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_shared_pref)

        // val sharedPref = applicationContext.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)

        binding.btnUpdateEmail.setOnClickListener {
            defaultSharedPref.edit().putString(KEY_EMAIL, "wahyu@gmail.com").apply()
        }

        binding.tvEmail.text = defaultSharedPref.getString(KEY_EMAIL, ". . . . .")

    }
}