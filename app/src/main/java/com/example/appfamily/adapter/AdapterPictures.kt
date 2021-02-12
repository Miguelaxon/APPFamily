package com.example.appfamily.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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
        RecyclerView.ViewHolder(binding.root), View.OnLongClickListener{
        fun bind(classPictures: ClassPictures){
            binding.iconILike.visibility = View.GONE
            Glide.with(binding.ivPictures)
                    .load(classPictures.pictures)
                    .into(binding.ivPictures)
            if (classPictures.favorites) binding.iconILike.visibility = View.VISIBLE
             else binding.iconILike.visibility = View.INVISIBLE
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            selectedPictures.value = listPictures[adapterPosition]
            return true
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