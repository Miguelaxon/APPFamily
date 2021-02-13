package com.example.appfamily.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "family_table")
data class ClassFamily (@PrimaryKey val name: String, val url: String)