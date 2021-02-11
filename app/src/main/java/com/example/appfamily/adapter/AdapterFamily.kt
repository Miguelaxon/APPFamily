package com.example.appfamily.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfamily.ClassFamily
import com.example.appfamily.ClassPictures
import com.example.appfamily.databinding.ItemFamilyBinding

class AdapterFamily: RecyclerView.Adapter<AdapterFamily.FamilyViewHolder>() {
    private var listFamily = listOf<ClassFamily>()
    private var selectedFamily = MutableLiveData<ClassFamily>()

    fun selectedFamily(): LiveData<ClassFamily> = selectedFamily

    fun update(list: List<ClassFamily>){
        listFamily = list
        notifyDataSetChanged()
    }

    inner class FamilyViewHolder(private val binding: ItemFamilyBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        fun bind(classFamily: ClassFamily){
            //val classPictures: ClassPictures? = null
            binding.tvMembers.text = classFamily.name.toUpperCase()
            /*Glide.with(binding.ivMembers).load(classPictures!!.pictures).circleCrop()
                .into(binding.ivMembers)*/
        }

        override fun onClick(v: View?) {
            selectedFamily.value = listFamily[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        return FamilyViewHolder(ItemFamilyBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        val lista = listFamily[position]
        holder.bind(lista)
    }

    override fun getItemCount(): Int = listFamily.size
}