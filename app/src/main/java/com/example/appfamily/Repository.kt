package com.example.appfamily

import android.util.Log
import androidx.lifecycle.LiveData

class Repository (private val familyDAO: FamilyDAO) {
    val listAllFamily: LiveData<List<ClassFamily>> = familyDAO.getAllFamily()

    suspend fun getFetchFamiliyCoroutines(){
        try {
            val response = ApiClient.getApiClient().getFetchFamily()
            when (response.isSuccessful){
                true -> response.body()?.let {
                    familyDAO.insertAllFamily(converterFamily(it.members))
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        } catch (t: Throwable){
            Log.d("Error Family Coroutine", t.message.toString())
        }
    }

    suspend fun getFetchPicturesCotoutines(members: String){
        try {
            val response = ApiClient.getApiClient().getFetchPictures(members)
            when (response.isSuccessful){
                true -> response.body()?.let {
                    Log.d("repo", "${it.pictures}")
                    familyDAO.insertAllPictures(converterPictures(it.pictures, members))
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()}")
            }
        } catch (t: Throwable){
            Log.d("Error Picture Coroutine", t.message.toString())
        }
    }

    fun converterFamily(list: List<Persons>): List<ClassFamily>{
        val listFamily: MutableList<ClassFamily> = mutableListOf()
        list.map {
            listFamily.add(ClassFamily(name = it.name, url = it.url))
        }
        return listFamily
    }

    fun converterPictures(list: List<String>, members: String): List<ClassPictures>{
        val listPictures: MutableList<ClassPictures> = mutableListOf()
        list.map {
            listPictures.add(ClassPictures(pictures = it, members = members, favorites = false))
        }
        return listPictures
    }

    fun getPicture(members: String): LiveData<List<ClassPictures>>{
        return familyDAO.getPicture(members)
    }

    suspend fun updateFav(classPictures: ClassPictures){
        familyDAO.update(classPictures)
    }
}