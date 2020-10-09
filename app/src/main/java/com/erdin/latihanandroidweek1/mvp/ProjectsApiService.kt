package com.erdin.latihanandroidweek1.mvp

import com.erdin.latihanandroidweek1.project.ProjectAddResponse
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ProjectsApiService {

    @GET("project/?limit=100")
    suspend fun getAllEmployee(@Query("limit") limit: Int?): ProjectsResponse

    @Multipart
    @POST("project")
    suspend fun postProject(
        @Part("name") projectName: RequestBody,
        @Part("description") projectDesc: RequestBody,
        @Part("price") projectPrice: RequestBody,
        @Part("duration") projectDuration: RequestBody,
        @Part image: MultipartBody.Part
    ): ProjectAddResponse

}