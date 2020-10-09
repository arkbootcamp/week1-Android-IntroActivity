package com.erdin.latihanandroidweek1.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erdin.latihanandroidweek1.mvp.ProjectsApiService
import kotlinx.coroutines.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import kotlin.coroutines.CoroutineContext

class AddProjectViewModel : ViewModel(), CoroutineScope {

    private lateinit var service: ProjectsApiService

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main


    fun setLoginService(service: ProjectsApiService) {
        this.service = service
    }

    fun postProjectApi(name: RequestBody, description: RequestBody, price: RequestBody,
                       duration: RequestBody, image: MultipartBody.Part) {
        launch {

            val response = withContext(Dispatchers.IO) {
                try {
                    service?.postProject(name, description, price, duration, image)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (response is ProjectAddResponse) {
                // Action Success
            }
        }
    }
}