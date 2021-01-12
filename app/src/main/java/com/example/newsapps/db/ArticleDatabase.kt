package com.example.newsapps.db

import android.content.Context
import androidx.room.*
import com.example.newsapps.mvvmnewsapp.Article

@Database(
        entities = [Article::class]
        ,version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase(){
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        //other threat can immediately see the when thread changes this instance
        private var INSTANCE: ArticleDatabase? = null
        private val Lock = Any()
         fun getInstance(context: Context) =
                INSTANCE
                        ?: synchronized(Lock) {
                    INSTANCE
                            ?: createDatabse(context).also { INSTANCE = it }
                }

        private fun createDatabse(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        ArticleDatabase::class.java, "newsapp_db.db").build()
    }
}
