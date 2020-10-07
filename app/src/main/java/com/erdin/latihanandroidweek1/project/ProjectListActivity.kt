package com.erdin.latihanandroidweek1.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.ActivityProjectListBinding
import com.erdin.latihanandroidweek1.mvp.ProjectsAdapter
import com.erdin.latihanandroidweek1.mvp.ProjectsApiService
import com.erdin.latihanandroidweek1.remote.ApiClient

class ProjectListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProjectListBinding
    private lateinit var viewModel: ProjectListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_project_list)

        binding.recyclerView.adapter = ProjectsAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val service = ApiClient.getApiClient(this)?.create(ProjectsApiService::class.java)

        viewModel = ViewModelProvider(this).get(ProjectListViewModel::class.java)

        subscribeLiveData()

        if (service != null) {
            viewModel.setProjectService(service)
        }
        viewModel.getProjectList()
    }

    private fun subscribeLiveData() {
        viewModel.projectListLiveData.observe(this, Observer {
            (binding.recyclerView.adapter as ProjectsAdapter).addList(it)
        })

        viewModel.isLoadingLiveData.observe(this, Observer {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}