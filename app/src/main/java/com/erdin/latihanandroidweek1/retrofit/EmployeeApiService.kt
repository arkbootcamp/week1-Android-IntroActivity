package com.erdin.latihanandroidweek1.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface EmployeeApiService {

    @GET("api/v1/employees")
    fun getEmployee(): Call<EmployeeResponse>

    @GET("api/v1/employees")
    suspend fun getAllEmployee(): EmployeeResponse


}