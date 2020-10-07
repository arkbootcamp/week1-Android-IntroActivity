package com.erdin.latihanandroidweek1.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.remote.ApiClient
import com.erdin.latihanandroidweek1.databinding.ActivityProjectsBinding
import kotlinx.coroutines.*

class ProjectsActivity : AppCompatActivity(), ProjectsContract.View {

    private lateinit var binding: ActivityProjectsBinding
    private lateinit var coroutineScope: CoroutineScope
    private var presenter: ProjectsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_projects)

        binding.recyclerView.adapter = ProjectsAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        coroutineScope = CoroutineScope(Job() + Dispatchers.Main)
        val service = ApiClient.getApiClient(this)?.create(ProjectsApiService::class.java)

        presenter = ProjectsPresenter(coroutineScope, service)

    }

    override fun onStart() {
        super.onStart()
        presenter?.bindToView(this)
        presenter?.callProjectApi()
    }

    override fun onStop() {
        presenter?.unbind()
        super.onStop()
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        presenter = null
        super.onDestroy()
    }


    override fun addListProject(list: List<ProjectsModel>) {
        (binding.recyclerView.adapter as ProjectsAdapter).addList(list)
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

}