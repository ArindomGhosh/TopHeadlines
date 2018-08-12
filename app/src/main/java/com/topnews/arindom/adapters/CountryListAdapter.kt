package com.topnews.arindom.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.topnews.arindom.R
import com.topnews.arindom.databinding.ItemCountryViewBinding

import com.topnews.arindom.network.CountryIsoMap

class CountryListAdapter(private var mCountryList: List<CountryIsoMap>) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {
    private var mOnCountrySelectListener: OnCountrySelectListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val mBinding = DataBindingUtil.inflate<ItemCountryViewBinding>(LayoutInflater.from(parent.context), R.layout.item_country_view, parent, false)
        return CountryViewHolder(mBinding)
    }

    override fun getItemCount() = mCountryList.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(mCountryList[position])
        holder.mBinding.root.setOnClickListener { mOnCountrySelectListener?.onCountryClicked(mCountryList[position]) }
    }

    inner class CountryViewHolder(val mBinding: ItemCountryViewBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(mCountryIsoMap: CountryIsoMap) {
            mBinding.mCountryIsoMap = mCountryIsoMap
        }
    }

    fun updateCountryList(mCountryList: List<CountryIsoMap>) {
        this.mCountryList = mCountryList
        notifyDataSetChanged()
    }

    fun setOnCountrySelectListener(mOnCountrySelectListener: OnCountrySelectListener) {
        this.mOnCountrySelectListener = mOnCountrySelectListener
    }

    interface OnCountrySelectListener {
        fun onCountryClicked(mCountryIsoMap: CountryIsoMap)
    }
}