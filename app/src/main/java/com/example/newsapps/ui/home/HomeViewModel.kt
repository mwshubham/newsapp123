package com.example.newsapps.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapps.api.NewsService
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    fun getNews() {
        Log.v(HomeFragment.TAG, "getNews() ${Thread.currentThread().name}")
        viewModelScope.launch {
            Log.v(HomeFragment.TAG, "getNews() launch{} START  ${Thread.currentThread().name}")
            val response = NewsService.newsInstance.getBreakingNews(countryCode = "in")
            if (response.isSuccessful){
                Log.v(HomeFragment.TAG, "getNews() launch{} END  ${Thread.currentThread().name}")
            }
        }
    }
}