package com.erdin.latihanandroidweek1.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface EmployeeApiService {

    @GET("api/v1/employees")
    fun getAllEmployee(): Call<EmployeeResponse>


}