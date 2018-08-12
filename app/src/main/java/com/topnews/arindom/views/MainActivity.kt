package com.topnews.arindom.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.topnews.arindom.R
import com.topnews.arindom.ViewModalFactory
import com.topnews.arindom.adapters.CountryListAdapter
import com.topnews.arindom.common.BaseActivity
import com.topnews.arindom.network.CountryIsoMap
import com.topnews.arindom.viewmodals.CountryISOCodeViewModal
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.generic.instance

const val COUNTRY_CODE_MAP = "country_code_map"

class MainActivity : BaseActivity(), CountryListAdapter.OnCountrySelectListener {
    private val mViewModalFactory: ViewModalFactory by instance()
    private val adapter by lazy { CountryListAdapter(listOf()) }
    private val mCountryCodeViewModal by lazy { ViewModelProviders.of(this, mViewModalFactory).get(CountryISOCodeViewModal::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Top Headlines of countries."

        adapter.setOnCountrySelectListener(this)
        rvCompanies.adapter = adapter
        rvCompanies.layoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        setViewModal(adapter)
    }

    private fun setViewModal(adapter: CountryListAdapter) {
        mCountryCodeViewModal.getCountryIsoCode().observe(this, Observer {
            it?.let { it1 -> adapter.updateCountryList(it1) }
        })
    }

    override fun onCountryClicked(mCountryIsoMap: CountryIsoMap) {
        startActivity(Intent(this, TopHeadlines::class.java).putExtra(COUNTRY_CODE_MAP, mCountryIsoMap))
    }
}
