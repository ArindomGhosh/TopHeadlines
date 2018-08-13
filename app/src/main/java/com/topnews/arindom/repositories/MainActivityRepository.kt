package com.topnews.arindom.repositories

import com.topnews.arindom.modals.CountryIsoMap

class MainActivityRepository {
    fun getCountryList() = listOf(CountryIsoMap("India", "IN"),
            CountryIsoMap("Australia", "AU"),
            CountryIsoMap("United States", "US"),
            CountryIsoMap("United Kingdom", "UK"),
            CountryIsoMap("China", "CN"),
            CountryIsoMap("Colombia", "Co"))
}