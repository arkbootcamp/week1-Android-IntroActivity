package com.erdin.latihanandroidweek1.auth

import android.content.Context
import com.erdin.latihanandroidweek1.sharedpref.LearnSharedPrefActivity
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor (val mContext: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(mContext)
        val token = defaultSharedPref.getString(LearnSharedPrefActivity.KEY_TOKEN, "")
        proceed(
            request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        )
    }


}