package com.erdin.latihanandroidweek1.mvp

import retrofit2.http.GET

interface ProjectsApiService {

    @GET("project")
    suspend fun getAllEmployee(): ProjectsResponse


}