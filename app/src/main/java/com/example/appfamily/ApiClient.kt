package com.example.appfamily

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        private const val URL_BASE = "http://demo4058102.mockable.io/"
        fun getApiClient(): IApi{
            val mRetrofit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return mRetrofit.create(IApi::class.java)
        }
    }
}