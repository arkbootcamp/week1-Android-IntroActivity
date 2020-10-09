package com.erdin.latihanandroidweek1.project

import com.google.gson.annotations.SerializedName

data class ProjectAddResponse(val success: String?, val message: String?, val data: Project) {

    data class Project(
        @SerializedName("name_project") val nameProject: String?,
        val description: String?,
        val price: String?,
        val duration: String?,
        val image: String?
    )
}