package com.erdin.latihanandroidweek1.retrofit

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(val status: String?, val data: List<Employee>) {

    data class Employee(val id: String?,
                        @SerializedName("employee_name") val name: String?,
                        @SerializedName("employee_salary") val salary: String?,
                        @SerializedName("employee_age") val age: String?,
                        @SerializedName("profile_image") val profileImage: String?
    )
}
