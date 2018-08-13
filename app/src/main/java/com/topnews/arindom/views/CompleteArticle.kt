package com.topnews.arindom.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.MenuItem
import com.topnews.arindom.R
import com.topnews.arindom.common.BaseActivity
import com.topnews.arindom.common.ImageLoader
import com.topnews.arindom.databinding.ActivityCompleteArticleBinding
import com.topnews.arindom.modals.ArticleNode

class CompleteArticle : BaseActivity() {
    private val mImageLoader by lazy { ImageLoader(this) }
    private val mBinding by lazy { DataBindingUtil.setContentView<ActivityCompleteArticleBinding>(this, R.layout.activity_complete_article) }
    private var mArticleNode: ArticleNode? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_article)
        mArticleNode = intent.getParcelableExtra(ARTICLE_DETAIL)
        title = mArticleNode?.title
        mBinding.mArticleNode = mArticleNode
        mArticleNode?.urlToImage?.let { mImageLoader.loadImage(it, mBinding.ivArticle) }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
