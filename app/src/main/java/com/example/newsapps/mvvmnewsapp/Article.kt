package com.example.newsapps.mvvmnewsapp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
     tableName="articles"
)
data class Article(
        @PrimaryKey(autoGenerate = true)
        val int: Int?=null,
        val author: String? = null,
        val content: String? = null,
        val description: String? = null,
        val publishedAt: String? = null,
        val source: Source,
        val title: String? = null,
        val url: String? = null,
        val urlToImage: String? = null
)