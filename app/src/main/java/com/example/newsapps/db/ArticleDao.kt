package com.example.newsapps.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapps.mvvmnewsapp.Article


@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetAll(articles: List<Article>):Long

    @Query("SELECT * FROM articles")
    fun getArticleById():LiveData<List<Article>>
}