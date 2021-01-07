package com.example.newsapps.Api

import com.example.newsapps.Api.Constants.Companion.API_KEY
import com.example.newsapps.Api.Constants.Companion.BASE_URL
import com.example.newsapps.mvvmnewsapp.NewsRespones
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
     fun getbreakingnews(
        @Query("country")
        countryCode:String="us",
        @Query("apiKey")
        apikey: String=API_KEY
    ):Response<NewsRespones>
}
object NewsService{
    val newsInstance:NewsApi
    init {
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsApi::class.java)
    }
}