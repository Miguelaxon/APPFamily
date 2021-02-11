package com.example.appfamily

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository
    val allFamily: LiveData<List<ClassFamily>>
    val selectedFamily: MutableLiveData<ClassFamily> = MutableLiveData()
    val selectedPictures: MutableLiveData<ClassPictures> = MutableLiveData()

    init {
        val baseDatos = BaseDatos.getDataBase(application).getFamilyDAO()
        repository = Repository(baseDatos)
        viewModelScope.launch {
            repository.getFetchFamiliyCoroutines()
        }
        allFamily = repository.listAllFamily
    }

    fun selectedPicture(member: String) = viewModelScope.launch {
        repository.getFetchPicturesCotoutines(member)
    }

    fun returnPicture(member: String): LiveData<List<ClassPictures>> = repository.getPicture(member)
}