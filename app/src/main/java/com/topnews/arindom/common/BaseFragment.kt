package com.topnews.arindom.common

import android.support.v4.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.support.closestKodein

abstract class BaseFragment: Fragment(),KodeinAware {
    override val kodein by closestKodein()
}