package com.example.newsapps.Api

import com.example.newsapps.Api.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RectrofitInstance {
//    companion object{
//        private val rectrofit by lazy {
//            val logging=HttpLoggingInterceptor()
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//            val client=OkHttpClient.Builder().addInterceptor(logging).build()
//            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
//                .client(client).build()
//        }
//        val api by lazy {
//            rectrofit.create(NewsApi::class.java)
//        }
//    }
}