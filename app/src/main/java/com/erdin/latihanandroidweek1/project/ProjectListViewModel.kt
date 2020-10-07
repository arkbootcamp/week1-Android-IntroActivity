package com.erdin.latihanandroidweek1.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erdin.latihanandroidweek1.mvp.ProjectsApiService
import com.erdin.latihanandroidweek1.mvp.ProjectsModel
import com.erdin.latihanandroidweek1.mvp.ProjectsResponse
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ProjectListViewModel : ViewModel(), CoroutineScope {

    val isLoadingLiveData = MutableLiveData<Boolean>()
    val projectListLiveData = MutableLiveData<List<ProjectsModel>>()

    private lateinit var service: ProjectsApiService

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    fun setProjectService(service: ProjectsApiService) {
        this.service = service
    }

    fun getProjectList() {
        launch {
            isLoadingLiveData.value = true

            val response = withContext(Dispatchers.IO) {
                try {
                    service?.getAllEmployee()
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (response is ProjectsResponse) {
                val list = response.data?.map {
                    ProjectsModel(it.idProject.orEmpty(), it.nameProject.orEmpty(), it.description.orEmpty(), it.duration.orEmpty())
                }

                projectListLiveData.value = list
            }

            isLoadingLiveData.value = false

        }
    }
}