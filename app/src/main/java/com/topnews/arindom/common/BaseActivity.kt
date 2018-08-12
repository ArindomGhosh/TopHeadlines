package com.topnews.arindom.common

import android.support.v7.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

abstract class BaseActivity: AppCompatActivity(),KodeinAware{
    override val kodein by closestKodein()
}