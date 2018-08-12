package com.topnews.arindom.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopHeadlinesApi {
    fun getTopHeadLines(countryCode: String, pages: Int, listener: TopHeadLinesAPIListener<TopHeadlinesResponse?, String>) {
        ApiServices.getInteface()
                .topHeadlinesApi(countryCode, NEWS_API_KEY, pages)
                .enqueue(object : Callback<TopHeadlinesResponse> {
                    override fun onFailure(call: Call<TopHeadlinesResponse>?, t: Throwable?) {
                        listener.onFail("Failed Retro Request")
                    }

                    override fun onResponse(call: Call<TopHeadlinesResponse>?, response: Response<TopHeadlinesResponse>?) {
                        if (response != null && response.isSuccessful) {
                            listener.onSuccess(response.body())
                        } else {
                            listener.onFail("Something went wrong")
                        }
                    }
                })
    }

    interface TopHeadLinesAPIListener<T, S> {
        fun onSuccess(response: T)
        fun onFail(failure: S)
    }
}