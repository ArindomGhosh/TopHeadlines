package com.topnews.arindom.inject

import com.topnews.arindom.ViewModalFactory
import com.topnews.arindom.repositories.MainActivityRepository
import com.topnews.arindom.repositories.TopHeadlinesRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val applicationModule=Kodein.Module(name = "BASIC_APP_MODULE"){
    bind<MainActivityRepository>() with singleton { MainActivityRepository() }
    bind<TopHeadlinesRepository>() with singleton { TopHeadlinesRepository() }
    bind<ViewModalFactory>() with singleton { ViewModalFactory(instance(),instance()) }
}