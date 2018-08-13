package com.topnews.arindom.viewmodals

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.topnews.arindom.modals.CountryIsoMap
import com.topnews.arindom.repositories.MainActivityRepository

class CountryISOCodeViewModal(val mMainActivityRepository: MainActivityRepository) : ViewModel() {
    private var mCountryCodeListLiveData = MutableLiveData<List<CountryIsoMap>>()

    fun getCountryIsoCode(): LiveData<List<CountryIsoMap>> {
        mCountryCodeListLiveData.value = mMainActivityRepository.getCountryList()
        return mCountryCodeListLiveData
    }
}