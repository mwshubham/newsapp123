package com.example.newsapps.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsapps.Api.NewsApi
import com.example.newsapps.Api.NewsService
import com.example.newsapps.R
import com.example.newsapps.mvvmnewsapp.NewsRespones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        getnews();
        return root
    }
    private fun getnews() {
        val news = NewsService.newsInstance.getbreakingnews("", "")
//        news.enqueue(object : Callback<NewsRespones> {
//            override fun onFailure(call: Call<NewsRespones>, t: Throwable) {
//                Log.d("news", "error in fatching news", t)
//            }
//
//            override fun onResponse(call: Call<NewsRespones>, response: Response<NewsRespones>) {
//                val news = response.body()
//                if (news != null) {
//                    Log.d("news", news.toString())
//                }
//            }
//
//
//        })
    }


}




