package com.example.newsapps.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapps.api.NewsRepository
import com.example.newsapps.db.ArticleDao
import com.example.newsapps.mvvmnewsapp.Article
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel(){


    val newMutableLiveData: MutableLiveData<List<Article>> = MutableLiveData()

    init {
        Log.d(TAG, "init{}")
    }

    fun getNews() {
        viewModelScope.launch {
            try {
                val response = newsRepository.getBreakingNews()
                Log.d(TAG, "getNews : ${response.body()}")
                if (response.isSuccessful && response.body() != null) {
                    newMutableLiveData.value = response.body()?.articles
                    response.body()?.articles?.let { newsRepository.insertAll(it) }
                }
            } catch (e: Exception) {
                Log.d(TAG, "getNews : ${e.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared()")
    }

    companion object {
        const val TAG = "NewsViewModel"
    }


}