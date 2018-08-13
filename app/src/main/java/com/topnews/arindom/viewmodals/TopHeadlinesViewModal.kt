package com.topnews.arindom.viewmodals

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.topnews.arindom.repositories.TopHeadlinesRepository
import com.topnews.arindom.modals.TopHeadlinesResponse

class TopHeadlinesViewModal(val mTopHeadlinesRepository: TopHeadlinesRepository) : ViewModel() {
    fun getTopHeadlinesLiveData(mCountryCode: String, pages: Int): LiveData<TopHeadlinesResponse> {
        val mTopHeadLinesLiveData = MutableLiveData<TopHeadlinesResponse>()
        mTopHeadlinesRepository.getTopHeadLines(mCountryCode, pages, object : TopHeadlinesRepository.TopHeadLinesAPIListener<TopHeadlinesResponse?, String> {
            override fun onSuccess(response: TopHeadlinesResponse?) {
                response?.let { mTopHeadLinesLiveData.value = it }
            }

            override fun onFail(failure: String) {

            }
        })
        return mTopHeadLinesLiveData
    }
}