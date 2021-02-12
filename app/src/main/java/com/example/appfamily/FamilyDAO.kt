package com.example.appfamily

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FamilyDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFamily(family: List<ClassFamily>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllPictures(pictures: List<ClassPictures>)

    @Query("SELECT * FROM family_table")
    fun getAllFamily(): LiveData<List<ClassFamily>>

    @Query("SELECT * FROM image_table WHERE members = :members")
    fun getPicture(members: String): LiveData<List<ClassPictures>>

    @Update
    suspend fun update(classPictures: ClassPictures)
}