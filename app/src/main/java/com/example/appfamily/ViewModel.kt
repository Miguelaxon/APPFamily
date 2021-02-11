package com.example.appfamily

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
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
}