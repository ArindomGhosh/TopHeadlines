package com.topnews.arindom

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.topnews.arindom.network.MainActivityAPI
import com.topnews.arindom.network.TopHeadlinesApi
import com.topnews.arindom.viewmodals.CountryISOCodeViewModal
import com.topnews.arindom.viewmodals.TopHeadlinesViewModal

class ViewModalFactory(private val mMainActivityAPI: MainActivityAPI,
                       private val mTopHeadlinesApi: TopHeadlinesApi) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            when (modelClass) {
                CountryISOCodeViewModal::class.java -> CountryISOCodeViewModal(mMainActivityAPI) as T
                TopHeadlinesViewModal::class.java-> TopHeadlinesViewModal(mTopHeadlinesApi)as T
                else -> throw IllegalArgumentException("Unknown model class.")
            }
}