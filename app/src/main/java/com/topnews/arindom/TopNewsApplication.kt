
package com.topnews.arindom

import android.app.Application
import com.topnews.arindom.inject.applicationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

class TopNewsApplication : Application(), KodeinAware{
    override val kodein= Kodein.lazy {
        import(applicationModule.copy ( "BASIC_APP_MODULE" ))
        import(androidModule(this@TopNewsApplication))
    }
}