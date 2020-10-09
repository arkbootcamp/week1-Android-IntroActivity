package com.erdin.latihanandroidweek1.mvp

import android.util.Log
import kotlinx.coroutines.*

class ProjectsPresenter(private val coroutineScope: CoroutineScope,
                        private val service: ProjectsApiService?) : ProjectsContract.Presenter {

    private var view: ProjectsContract.View? = null

    override fun bindToView(view: ProjectsContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }

    override fun callProjectApi() {

        coroutineScope.launch {
        view?.showProgressBar()
            Log.d("android1", "start : ${Thread.currentThread().name}")

            val response = withContext(Dispatchers.IO) {
                Log.d("android1", "callApi : ${Thread.currentThread().name}")
                try {
                    service?.getAllEmployee(100)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }

            if (response is ProjectsResponse) {
                val list = response.data?.map {
                    ProjectsModel(it.idProject.orEmpty(), it.nameProject.orEmpty(), it.description.orEmpty(), it.duration.orEmpty())
                }

                view?.addListProject(list)
            } else if (response is Throwable) {
                Log.e("android1", response.message ?: "Error")
            }

            view?.hideProgressBar()
            Log.d("android1", "finish : ${Thread.currentThread().name}")
        }

    }
}