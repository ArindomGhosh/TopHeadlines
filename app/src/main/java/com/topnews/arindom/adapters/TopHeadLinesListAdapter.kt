package com.topnews.arindom.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.topnews.arindom.R
import com.topnews.arindom.common.ImageLoader
import com.topnews.arindom.databinding.ItemsArticlesViewBinding
import com.topnews.arindom.modals.ArticleNode

class TopHeadLinesListAdapter(private val mImageLoader: ImageLoader, private var mTopHeadlineList: MutableList<ArticleNode>) : RecyclerView.Adapter<TopHeadLinesListAdapter.TopHeadLinesviewHolder>() {
    private var mOnArticleClickListener: OnArticleClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadLinesviewHolder {
        val mBinding = DataBindingUtil.inflate<ItemsArticlesViewBinding>(LayoutInflater.from(parent.context), R.layout.items_articles_view, parent, false)
        return TopHeadLinesviewHolder(mBinding)
    }

    override fun getItemCount() = mTopHeadlineList.size

    override fun onBindViewHolder(holder: TopHeadLinesviewHolder, position: Int) {
        holder.bind(mTopHeadlineList[position])
        holder.mBinding.root.setOnClickListener { mOnArticleClickListener?.onArticleClicked(mTopHeadlineList[position]) }
    }

    inner class TopHeadLinesviewHolder(val mBinding: ItemsArticlesViewBinding) : RecyclerView.ViewHolder(mBinding.root) {
        fun bind(mArticleNode: ArticleNode) {
            mBinding.mArticleNode = mArticleNode
            mArticleNode.urlToImage?.let { mImageLoader.loadImage(it, mBinding.ivArticle) }
        }
    }

    fun setOnArticleClickListener(mOnArticleClickListener: OnArticleClickListener) {
        this.mOnArticleClickListener = mOnArticleClickListener
    }

    fun updateArticleList(mTopHeadlineList: List<ArticleNode>) {
        this.mTopHeadlineList.addAll(mTopHeadlineList)
        notifyDataSetChanged()
    }

    interface OnArticleClickListener {
        fun onArticleClicked(mArticleNode: ArticleNode)
    }
}