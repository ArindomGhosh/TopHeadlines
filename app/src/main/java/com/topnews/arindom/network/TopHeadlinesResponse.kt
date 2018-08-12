package com.topnews.arindom.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*{
    "status": "ok",
    "totalResults": 20,
    "articles": [
        { "source": {
            "id": "the-times-of-india",
            "name": "The Times of India"
            },
            "author": "Vijay Singh",
            "title": "Navi Mumbai CA assaulted at Pune five-star during bandh",
            "description": "\"On Wednesday, I was attending a conference on modern technological advancements in the field of electric vehicles at a five-star hotel in Pune.",
            "url": "https://timesofindia.indiatimes.com/city/navi-mumbai/navi-mumbai-ca-assaulted-at-pune-five-star-during-bandh/articleshow/65361884.cms",
            "urlToImage": "https://static.toiimg.com/thumb/msid-65361897,width-1070,height-580,imgsize-1506496,resizemode-6,overlay-toi_sw,pt-32,y_pad-40/photo.jpg",
            "publishedAt": "2018-08-11T03:13:00Z"
        }
    ]
}*/

@Parcelize
data class TopHeadlinesResponse(val totalResults: Int, val articles: List<ArticleNode>) : BaseResponse(), Parcelable

@Parcelize
data class ArticleNode(val source: SourceNode,
                       val author: String?,
                       val title: String?,
                       val description: String?,
                       val url: String?,
                       val urlToImage: String?,
                       val publishedAt: String?) : Parcelable

@Parcelize
data class SourceNode(val id: String?,
                      val name: String?) : Parcelable
