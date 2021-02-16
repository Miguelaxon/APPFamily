package com.example.appfamily.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appfamily.databinding.ItemPicturesBinding

class AdapterContact {
    inner class ContactViewHolder(private val binding: ItemPicturesBinding):
            RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        override fun onClick(v: View?) {
            itemView.setOnClickListener(this)
        }

    }
}