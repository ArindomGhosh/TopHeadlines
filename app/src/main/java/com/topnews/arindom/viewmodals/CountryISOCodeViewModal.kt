package com.topnews.arindom.viewmodals

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.topnews.arindom.network.CountryIsoMap
import com.topnews.arindom.network.MainActivityAPI

class CountryISOCodeViewModal(val mMainActivityAPI: MainActivityAPI) : ViewModel() {
    private var mCountryCodeListLiveData = MutableLiveData<List<CountryIsoMap>>()

    fun getCountryIsoCode(): LiveData<List<CountryIsoMap>> {
        mCountryCodeListLiveData.value = mMainActivityAPI.getCountryList()
        return mCountryCodeListLiveData
    }
}