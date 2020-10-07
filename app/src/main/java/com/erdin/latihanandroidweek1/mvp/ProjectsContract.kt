package com.erdin.latihanandroidweek1.mvp

interface ProjectsContract {

    interface View {
        fun addListProject(list: List<ProjectsModel>)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface Presenter {
        fun bindToView(view: View)
        fun unbind()
        fun callProjectApi()
    }
}