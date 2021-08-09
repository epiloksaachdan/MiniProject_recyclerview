package com.achdanepiloksa.belajar_layouting.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.achdanepiloksa.belajar_layouting.R
import com.achdanepiloksa.belajar_layouting.home.model.Model

class Adapter(val listData: MutableList<Model>): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(listData[position])
        holder.btnDelete.setOnClickListener{
            listData.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,listData.size)
        }

    }

    override fun getItemCount(): Int {
        return listData.size
    }

}