package com.topnews.arindom.network

class MainActivityAPI {
    fun getCountryList() = listOf(CountryIsoMap("India", "IN"),
            CountryIsoMap("Australia", "AU"),
            CountryIsoMap("United States", "US"),
            CountryIsoMap("United Kingdom", "UK"),
            CountryIsoMap("China", "CN"),
            CountryIsoMap("Colombia", "Co"))
}