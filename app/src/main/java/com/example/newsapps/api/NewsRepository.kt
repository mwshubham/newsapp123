package com.example.newsapps.api

import com.example.newsapps.mvvmnewsapp.NewsResponses
import retrofit2.Response

/**
 * It provide news from server or from database.
 */
class NewsRepository() {
    suspend fun getBreakingNews(): Response<NewsResponses> = NewsService.newsInstance.getBreakingNews(countryCode = "in")

}