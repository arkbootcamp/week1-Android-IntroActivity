package com.erdin.latihanandroidweek1.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erdin.latihanandroidweek1.R
import java.util.*

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordListViewHolder>() {

    private val items = mutableListOf<WordRoomEntity>()

    fun addItems(words: List<WordRoomEntity>) {
        items.clear()
        items.addAll(words)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WordListViewHolder, position: Int) {
        val word = items[position]
        holder.tvWordNo.text = word.id.toString()
        holder.tvWordName.text = word.name
        holder.tvCreatedDate.text = formatDate(word.createdAt)
    }

    private fun formatDate(date: Long) : String {
        val formattedDate: String
        val c = Calendar.getInstance()
        c.timeInMillis = date
        formattedDate = "${c.get(Calendar.DAY_OF_MONTH)}-${c.get(Calendar.MONTH)}-${c.get(Calendar.YEAR)} ${c.get(Calendar.HOUR_OF_DAY)}:${c.get(Calendar.MINUTE)}"
        return formattedDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordListViewHolder {
        return WordListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false))
    }

    class WordListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvWordNo = itemView.findViewById<TextView>(R.id.tv_word_no)
        val tvWordName = itemView.findViewById<TextView>(R.id.tv_word_name)
        val tvCreatedDate = itemView.findViewById<TextView>(R.id.tv_created_date)
    }


}