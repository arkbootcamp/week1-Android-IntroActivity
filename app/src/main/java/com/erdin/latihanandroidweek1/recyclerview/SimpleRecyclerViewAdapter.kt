package com.erdin.latihanandroidweek1.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erdin.latihanandroidweek1.R

class SimpleRecyclerViewAdapter : RecyclerView.Adapter<SimpleRecyclerViewAdapter.FruitViewHolder>() {

    val listFruits = listOf("Pisang", "Apel", "Jambu", "Mangga",
        "Mengkudu", "Durian", "Sirsak", "Anggur", "Maja", "Jeruk", "Kelengkeng", "Pepaya", "Srikaya", "Semangka", "Melon",
        "Salak", "Nanas", "Rambutan", "Manggis", "Sawo", "Cempedak", "Nangka", "Delima", "Mentaga")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        return FruitViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_fruit, parent, false))
    }

    override fun getItemCount(): Int = listFruits.size

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.tvName.text = listFruits[position]
        holder.tvPosition.text = (position + 1).toString()
    }


    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById<TextView>(R.id.tv_name_item)
        var tvPosition: TextView = itemView.findViewById<TextView>(R.id.tv_position)
    }

}