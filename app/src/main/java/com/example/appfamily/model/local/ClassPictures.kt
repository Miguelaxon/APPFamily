package com.example.appfamily.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class ClassPictures (@PrimaryKey var pictures: String,
                          var members: String,
                          var favorites: Boolean)