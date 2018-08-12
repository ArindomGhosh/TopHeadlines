package com.topnews.arindom.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterfaces {
    @GET("top-headlines")
    fun topHeadlinesApi(@Query("country") mCountry: String, @Query("apiKey") mApiKey: String, @Query("page") pages: Int): Call<TopHeadlinesResponse>
}