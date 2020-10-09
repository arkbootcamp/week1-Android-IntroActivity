package com.erdin.latihanandroidweek1.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import kotlinx.coroutines.*

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

        binding.etSearchBox.addTextChangedListener(object : TextWatcher {
            private var searchFor = ""

            override fun afterTextChanged(s: Editable?) = Unit
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val searchText = s.toString().trim()
                if (searchText == searchFor)
                    return

                searchFor = searchText
                val coroutineScope = CoroutineScope(Job() + Dispatchers.Main)
                coroutineScope.launch {
                    delay(300)  //debounce timeOut
                    if (searchText != searchFor)
                        return@launch

                    viewModel.getProjectList(searchFor)
                }
            }
        })

        viewModel.getProjectList("")

        binding.btnAddProject.setOnClickListener {
            val intent = Intent(this, AddProjectActivity::class.java)
            startActivity(intent)
        }
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