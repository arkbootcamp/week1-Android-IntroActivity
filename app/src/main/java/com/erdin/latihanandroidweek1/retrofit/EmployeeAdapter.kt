package com.erdin.latihanandroidweek1.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.ItemEmployeeBinding

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>() {

    private val items = mutableListOf<EmployeeModel>()

    fun addList(list: List<EmployeeModel>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        return EmployeeHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_employee, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        val item = items[position]
        holder.binding.tvAge.text = item.age
        holder.binding.tvName.text = item.name
        holder.binding.tvSalary.text = item.salary
    }

    class EmployeeHolder( val binding: ItemEmployeeBinding) : RecyclerView.ViewHolder(binding.root)
}