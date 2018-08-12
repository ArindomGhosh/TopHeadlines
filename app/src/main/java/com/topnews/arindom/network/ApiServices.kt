package com.topnews.arindom.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServices {
    private fun createRetrofitClient() = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getInteface() = createRetrofitClient().create(ApiInterfaces::class.java)
}