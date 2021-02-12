package com.example.appfamily

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "family_table")
data class ClassFamily (@PrimaryKey val name: String, val url: String)