package com.example.newsapps.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapps.R
import com.example.newsapps.mvvmnewsapp.Article

class HomeAdapter(
    val context: Context,
    val articles: List<Article>
) :
    RecyclerView.Adapter<HomeAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.fragmenthome_adapter, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articles = articles[position]
        holder.title.text = articles.title
        holder.desc.text = articles.description
        holder.title.text = articles.title
        Glide.with(context).load(articles.urlToImage).into(holder.newImage)
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newImage = itemView.findViewById<ImageView>(R.id.img)
        var shadow_boottom = itemView.findViewById<ImageView>(R.id.shadow_boottom)
        var tv_test = itemView.findViewById<TextView>(R.id.tv_test)
        var publiesdat = itemView.findViewById<TextView>(R.id.publiesdat)
        var title = itemView.findViewById<TextView>(R.id.title)
        var desc = itemView.findViewById<TextView>(R.id.desc)
        var source = itemView.findViewById<TextView>(R.id.source)
        var time = itemView.findViewById<TextView>(R.id.time)
    }

}