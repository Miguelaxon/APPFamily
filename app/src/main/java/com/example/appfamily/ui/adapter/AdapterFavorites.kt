package com.example.appfamily.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfamily.databinding.ItemFavoritesBinding
import com.example.appfamily.model.local.ClassPictures

class AdapterFavorites: RecyclerView.Adapter<AdapterFavorites.FavoritesViewHolder>() {
    private var listFavorites = listOf<ClassPictures>()
    private var selectedFavorites = MutableLiveData<ClassPictures>()

    fun selectedFavorites(): LiveData<ClassPictures> = selectedFavorites

    fun update(list: List<ClassPictures>){
        listFavorites = list
        notifyDataSetChanged()
    }

    inner class FavoritesViewHolder(private val binding: ItemFavoritesBinding):
        RecyclerView.ViewHolder(binding.root), View.OnLongClickListener{
        fun bind(classPictures: ClassPictures){
            if (classPictures.favorites){
                Glide.with(binding.ivFavorites)
                    .load(classPictures.pictures)
                    .circleCrop()
                    .into(binding.ivFavorites)
            }
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            selectedFavorites.value = listFavorites[adapterPosition]
            return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val lista = listFavorites[position]
        holder.bind(lista)
    }

    override fun getItemCount(): Int = listFavorites.size
}