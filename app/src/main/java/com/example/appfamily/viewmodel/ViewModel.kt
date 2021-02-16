package com.example.appfamily.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.appfamily.model.local.ClassFamily
import com.example.appfamily.model.local.ClassPictures
import com.example.appfamily.model.Repository
import com.example.appfamily.model.local.BaseDatos
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository
    val allFamily: LiveData<List<ClassFamily>>
    private var members: String = ""

    init {
        val baseDatos = BaseDatos.getDataBase(application).getFamilyDAO()
        repository = Repository(baseDatos)
        viewModelScope.launch {
            repository.getFetchFamiliyCoroutines()
        }
        allFamily = repository.listAllFamily
    }

    fun selectedPicture(member: String) = viewModelScope.launch {
        members = member
        repository.getFetchPicturesCotoutines(member)
    }

    fun returnPicture(): LiveData<List<ClassPictures>> = repository.getPicture(members)

    fun returnFavorites(): LiveData<List<ClassPictures>> = repository.getFavorites()

    fun updateFavImage(classPictures: ClassPictures) = viewModelScope.launch {
        repository.updateFav(classPictures)
    }
}