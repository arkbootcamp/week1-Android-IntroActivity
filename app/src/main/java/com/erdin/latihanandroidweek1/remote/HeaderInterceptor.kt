package com.erdin.latihanandroidweek1.remote

import android.content.Context
import com.erdin.latihanandroidweek1.sharedpref.LearnSharedPrefActivity
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor (val mContext: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val defaultSharedPref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(mContext)
        val token = defaultSharedPref.getString(LearnSharedPrefActivity.KEY_TOKEN, "")
        val tokenAuth = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo2LCJ1c2VyX25hbWUiOiJSb3N5aWRhIiwidXNlcl9lbWFpbCI6InJvc3lpZGFAZ21haWwuY29tIiwidXNlcl9yb2xlIjoxLCJ1c2VyX3N0YXR1cyI6MCwiaWF0IjoxNjAyMDQyODA1LCJleHAiOjE2MDIwNDY0MDV9.DsvqXQbH-nmBBYWRlI8GL8Qv5S8UgL4ajzW-uQa04z4"
        proceed(
            request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        )
    }


}