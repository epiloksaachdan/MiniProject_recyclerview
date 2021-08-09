package com.achdanepiloksa.belajar_layouting.home.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.achdanepiloksa.belajar_layouting.home.model.Model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val btnDelete = itemView.btn_delete
    fun setData(data: Model){
        itemView.tv_name.text = data.name
        Picasso.get().load(data.imageURL).into(itemView.iv_image)
    }
}