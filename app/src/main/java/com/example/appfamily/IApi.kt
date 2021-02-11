package com.example.appfamily

import retrofit2.Response
import retrofit2.http.GET

interface IApi {
    @GET("familiaahumadafarfan/listaintegrantes")
    suspend fun getFetchFamily(): Response<ListFamily>

    @GET("familiaahumadafarfan/{members}")
    suspend fun getFetchPictures(): Response<ListImage>
}