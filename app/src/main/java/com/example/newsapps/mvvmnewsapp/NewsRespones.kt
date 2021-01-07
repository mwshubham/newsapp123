package com.example.newsapps.mvvmnewsapp

data class NewsRespones(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)