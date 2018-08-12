package com.topnews.arindom.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryIsoMap(val countryName: String,
                         val isoCode: String):Parcelable