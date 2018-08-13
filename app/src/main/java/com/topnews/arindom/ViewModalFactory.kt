package com.topnews.arindom

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.topnews.arindom.repositories.MainActivityRepository
import com.topnews.arindom.repositories.TopHeadlinesRepository
import com.topnews.arindom.viewmodals.CountryISOCodeViewModal
import com.topnews.arindom.viewmodals.TopHeadlinesViewModal

class ViewModalFactory(private val mMainActivityRepository: MainActivityRepository,
                       private val mTopHeadlinesRepository: TopHeadlinesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            when (modelClass) {
                CountryISOCodeViewModal::class.java -> CountryISOCodeViewModal(mMainActivityRepository) as T
                TopHeadlinesViewModal::class.java-> TopHeadlinesViewModal(mTopHeadlinesRepository)as T
                else -> throw IllegalArgumentException("Unknown model class.")
            }
}