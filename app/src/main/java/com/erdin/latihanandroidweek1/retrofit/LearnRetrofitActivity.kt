package com.erdin.latihanandroidweek1.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.auth.ApiClient
import com.erdin.latihanandroidweek1.databinding.ActivityLearnRetrofitBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LearnRetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learn_retrofit)

        binding.recyclerView.adapter = EmployeeAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        useCoroutineToCallAPI()
    }

    private fun useRetrofitToCallAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EmployeeApiService::class.java)

        binding.progressBar.visibility = View.VISIBLE
        service.getEmployee().enqueue(object : Callback<EmployeeResponse> {
            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Log.d("android1", "onFailure : ${Thread.currentThread().name}")
                Log.e("android1", t.message ?: "error")
            }

            override fun onResponse(
                call: Call<EmployeeResponse>,
                response: Response<EmployeeResponse>
            ) {
                binding.progressBar.visibility = View.GONE
                Log.d("android1", "onSuccess : ${Thread.currentThread().name}")
                val list = response.body()?.data?.map {
                    EmployeeModel(it.id.orEmpty(), it.name.orEmpty(), it.salary.orEmpty(), it.age.orEmpty())
                } ?: listOf()
                (binding.recyclerView.adapter as EmployeeAdapter).addList(list)
            }

        })
    }

    private fun useCoroutineToCallAPI() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://dummy.restapiexample.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EmployeeApiService::class.java)

        val coroutineScope = CoroutineScope(Job() +Dispatchers.Main)

        coroutineScope.launch {
            binding.progressBar.visibility = View.VISIBLE
            Log.d("android1", "start : ${Thread.currentThread().name}")

            val response = withContext(Dispatchers.IO) {
                Log.d("android1", "callApi : ${Thread.currentThread().name}")
                try {
                    service.getAllEmployee()
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
            }
            Log.d("android1", response.toString())
            if (response is EmployeeResponse) {
                val list = response.data?.map {
                    EmployeeModel(it.id.orEmpty(), it.name.orEmpty(), it.salary.orEmpty(), it.age.orEmpty())
                } ?: listOf()

                (binding.recyclerView.adapter as EmployeeAdapter).addList(list)
            } else if (response is Throwable) {
                Log.e("android1", response.message ?: "Error")
            }
        }

        binding.progressBar.visibility = View.GONE
        Log.d("android1", "finish : ${Thread.currentThread().name}")


    }

}