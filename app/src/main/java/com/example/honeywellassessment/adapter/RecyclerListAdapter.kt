package com.example.honeywellassessment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.honeywellassessment.R
import com.example.honeywellassessment.model.Item

class RecyclerListAdapter(private val itemList: ArrayList<Item>) :
    RecyclerView.Adapter<RecyclerListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.imageView.setImageResource(item.image)
        holder.nameView.text = item.name
        holder.colorView.text = item.color

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_image)
        val nameView: TextView = itemView.findViewById(R.id.tv_name)
        val colorView: TextView = itemView.findViewById(R.id.tv_color)
    }
}