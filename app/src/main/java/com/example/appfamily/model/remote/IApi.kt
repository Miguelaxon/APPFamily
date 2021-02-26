package com.example.appfamily.model.remote

import com.example.appfamily.ListFamily
import com.example.appfamily.ListImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IApi {
    @GET("familiaahumadafarfan/listaintegrantes")
    suspend fun getFetchFamily(): Response<ListFamily>

    @GET("familiaahumadafarfan/{members}")
    suspend fun getFetchPictures(@Path("members") members: String): Response<ListImage>

    @POST("familiaahumadafarfan/listaintegrantes")
    suspend fun postFetchFamily()
}