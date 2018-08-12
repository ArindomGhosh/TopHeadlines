package com.topnews.arindom.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.topnews.arindom.R
import com.topnews.arindom.ViewModalFactory
import com.topnews.arindom.adapters.PageinationListener
import com.topnews.arindom.adapters.TopHeadLinesListAdapter
import com.topnews.arindom.common.BaseActivity
import com.topnews.arindom.common.ImageLoader
import com.topnews.arindom.network.ArticleNode
import com.topnews.arindom.network.CountryIsoMap
import com.topnews.arindom.viewmodals.TopHeadlinesViewModal
import kotlinx.android.synthetic.main.activity_top_headlines.*
import org.kodein.di.generic.instance

const val ARTICLE_DETAIL = "article_detail"

class TopHeadlines : BaseActivity(), TopHeadLinesListAdapter.OnArticleClickListener {
    private var mCountryIsoMap: CountryIsoMap? = null
    private var mArticles = mutableListOf<ArticleNode>()
    private val mTopHeadlinesViewModal by lazy { ViewModelProviders.of(this, mViewModalFactory).get(TopHeadlinesViewModal::class.java) }
    private val adapter by lazy { TopHeadLinesListAdapter(ImageLoader(this), mutableListOf()) }
    private val mViewModalFactory: ViewModalFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_headlines)
        mCountryIsoMap = intent.getParcelableExtra(COUNTRY_CODE_MAP)
        title = mCountryIsoMap?.countryName


        val linearLayoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        adapter.setOnArticleClickListener(this)

        rvArticles.adapter = adapter
        rvArticles.layoutManager = linearLayoutManager
        rvArticles.addOnScrollListener(object : PageinationListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                if (adapter.itemCount == mArticles.size)
                    loadNewsArticles(mTopHeadlinesViewModal, adapter, totalItemsCount)
            }
        })
        loadNewsArticles(mTopHeadlinesViewModal, adapter, 0)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadNewsArticles(mTopHeadlinesViewModal: TopHeadlinesViewModal, adapter: TopHeadLinesListAdapter, pages: Int) {
        mTopHeadlinesViewModal.getTopHeadlinesLiveData(mCountryIsoMap!!.isoCode, pages)
                .observe(this, Observer {
                    it?.let { updateAdapter(it.articles) }
                    pbTopHeadlines.visibility = View.GONE
                })
    }

    private fun updateAdapter(articles: List<ArticleNode>) {
        mArticles.addAll(articles)
        adapter.updateArticleList(articles)
    }

    override fun onArticleClicked(mArticleNode: ArticleNode) {
        startActivity(Intent(this, CompleteArticle::class.java).putExtra(ARTICLE_DETAIL, mArticleNode))
    }

    override fun onDestroy() {
        super.onDestroy()
        mArticles.clear()
    }
}
