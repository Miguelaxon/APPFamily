package com.example.appfamily.model.local

import com.google.gson.annotations.SerializedName

data class Persons(@SerializedName("name") val name: String,
                   @SerializedName("url") val url: String)
