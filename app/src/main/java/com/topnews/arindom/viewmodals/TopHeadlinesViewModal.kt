package com.topnews.arindom.viewmodals

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.topnews.arindom.network.TopHeadlinesApi
import com.topnews.arindom.network.TopHeadlinesResponse

class TopHeadlinesViewModal(val mTopHeadlinesApi: TopHeadlinesApi) : ViewModel() {
    fun getTopHeadlinesLiveData(mCountryCode: String, pages: Int): LiveData<TopHeadlinesResponse> {
        val mTopHeadLinesLiveData = MutableLiveData<TopHeadlinesResponse>()
        mTopHeadlinesApi.getTopHeadLines(mCountryCode, pages, object : TopHeadlinesApi.TopHeadLinesAPIListener<TopHeadlinesResponse?, String> {
            override fun onSuccess(response: TopHeadlinesResponse?) {
                response?.let { mTopHeadLinesLiveData.value = it }
            }

            override fun onFail(failure: String) {

            }
        })
        return mTopHeadLinesLiveData
    }
}