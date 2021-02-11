package com.example.appfamily

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IApi {
    @GET("familiaahumadafarfan/listaintegrantes")
    suspend fun getFetchFamily(): Response<ListFamily>

    @GET("familiaahumadafarfan/{members}")
    suspend fun getFetchPictures(@Path("members") members: String): Response<ListImage>
}