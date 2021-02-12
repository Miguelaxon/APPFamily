package com.example.appfamily

import com.google.gson.annotations.SerializedName

data class ListFamily(@SerializedName("members")
                      val members: List<Persons>)

data class ListImage(@SerializedName("pictures")
                     val pictures: List<String>)