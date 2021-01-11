package com.example.newsapps.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapps.R
import com.example.newsapps.api.NewsRepository
import com.example.newsapps.mvvmnewsapp.Article
import com.example.newsapps.ui.adapter.HomeAdapter
import com.example.newsapps.viewmodel.NewsViewModel
import com.example.newsapps.viewmodel.NewsViewModelFactory
import java.util.ArrayList


class HomeFragment : Fragment() {
    private  lateinit var rv_recyle: RecyclerView
    private  lateinit var homeAdapter: HomeAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
         rv_recyle = root.findViewById(R.id.rv_recyle)
        homeRecycleVew()
        val newsRepository=NewsRepository()
        val newsViewModelFactory=NewsViewModelFactory(newsRepository)
        newsViewModel=ViewModelProvider(this,newsViewModelFactory)[NewsViewModel::class.java]
        Log.v(TAG, "Calling getNews() ${Thread.currentThread().name}")
        newsViewModel.getNews()
        Log.v(TAG, "Calling FINAL ${Thread.currentThread().name}")
        newsViewModel.newMutableLiveData.observe(viewLifecycleOwner, Observer {
            homeAdapter.setdata(it as List<Article>)
        })
        return root
    }

    companion object {
        const val TAG = "HomeFragment" }
    private fun homeRecycleVew(){
        homeAdapter= HomeAdapter(requireContext(),ArrayList())
        rv_recyle.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(activity)
            adapter=homeAdapter

        }

    }
}




