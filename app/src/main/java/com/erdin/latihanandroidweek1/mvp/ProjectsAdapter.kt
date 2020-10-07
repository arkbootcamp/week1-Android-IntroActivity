package com.erdin.latihanandroidweek1.mvp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.ItemEmployeeBinding
import com.erdin.latihanandroidweek1.databinding.ItemProjectBinding

class ProjectsAdapter : RecyclerView.Adapter<ProjectsAdapter.ProjectsHolder>() {

    private val items = mutableListOf<ProjectsModel>()

    fun addList(list: List<ProjectsModel>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsHolder {
        return ProjectsHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_project, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProjectsHolder, position: Int) {
        val item = items[position]
        holder.binding.tvDuration.text = item.duration
        holder.binding.tvName.text = item.name
        holder.binding.tvDesc.text = item.description
    }

    class ProjectsHolder( val binding: ItemProjectBinding) : RecyclerView.ViewHolder(binding.root)
}