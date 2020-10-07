package com.erdin.latihanandroidweek1.mvp

import com.google.gson.annotations.SerializedName

data class ProjectsResponse(val success: String?, val message: String?, val data: List<Project>) {

    data class Project(@SerializedName("id_project") val idProject: String?,
                        @SerializedName("name_project") val nameProject: String?,
                        val description: String?,
                        val price: String?,
                        val duration: String?,
                        val image: String?
    )
}
