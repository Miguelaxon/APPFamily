package com.example.appfamily.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfamily.ClassPictures
import com.example.appfamily.databinding.ItemPicturesBinding

class AdapterPictures: RecyclerView.Adapter<AdapterPictures.PicturesViewHolder>() {
    private var listPictures = listOf<ClassPictures>()
    private var selectedPictures = MutableLiveData<ClassPictures>()

    fun selectedPictures(): LiveData<ClassPictures> = selectedPictures

    fun update(list: List<ClassPictures>){
        listPictures = list
        notifyDataSetChanged()
    }

    inner class PicturesViewHolder(private val binding: ItemPicturesBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        fun bind(classPictures: ClassPictures){
            Glide.with(binding.ivPictures).load(classPictures.pictures).centerCrop()
                .into(binding.ivPictures)
        }

        override fun onClick(v: View?) {
            selectedPictures.value = listPictures[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicturesViewHolder {
        return PicturesViewHolder(ItemPicturesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PicturesViewHolder, position: Int) {
        val lista = listPictures[position]
        holder.bind(lista)
    }

    override fun getItemCount(): Int = listPictures.size
}