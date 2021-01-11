package com.example.newsapps.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapps.api.NewsRepository
import com.example.newsapps.mvvmnewsapp.NewsResponses
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel(){
    val newMutableLiveData:MutableLiveData<Response<NewsResponses>> = MutableLiveData()
    fun getNews(){
        viewModelScope.launch {
            try {
                val response=newsRepository.getBreakingNews()
                newMutableLiveData.value =response
                Log.d("respones","getNews : ${response.body()}")
            }catch (e:Exception){
                Log.d("error","getNews : ${e.message}")
            }


        }
    }


}