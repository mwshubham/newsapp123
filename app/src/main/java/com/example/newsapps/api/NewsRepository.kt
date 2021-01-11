package com.example.newsapps.api

import com.example.newsapps.mvvmnewsapp.NewsResponses
import retrofit2.Response
import retrofit2.Retrofit

class NewsRepository {
    suspend fun getBreakingNews(): Response<NewsResponses> = NewsService.newsInstance.getBreakingNews(countryCode = "in")
}