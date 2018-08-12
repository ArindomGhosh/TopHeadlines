package com.topnews.arindom.inject

import com.topnews.arindom.ViewModalFactory
import com.topnews.arindom.network.MainActivityAPI
import com.topnews.arindom.network.TopHeadlinesApi
import com.topnews.arindom.viewmodals.CountryISOCodeViewModal
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val applicationModule=Kodein.Module(name = "BASIC_APP_MODULE"){
    bind<MainActivityAPI>() with singleton { MainActivityAPI() }
    bind<TopHeadlinesApi>() with singleton { TopHeadlinesApi() }
    bind<ViewModalFactory>() with singleton { ViewModalFactory(instance(),instance()) }
}