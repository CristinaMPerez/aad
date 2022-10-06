package com.crismperez.aad.ut01.ex03.data

import android.content.SharedPreferences
import com.crismperez.aad.ut01.ex03.domain.News
import com.google.gson.Gson
import com.google.gson.stream.JsonReader

class NewsLocalSource(val sharedPref:SharedPreferences) {

    fun setNews(news: News){
        val gson = Gson ()
        val jsonNews = gson.toJson(news, News::class.java)
        val editor = sharedPref.edit()

        editor.putString(news.id.toString(), jsonNews)
        editor.apply()
    }

    fun findByid(newsId : Int): News? {
        val gson = Gson()

        val jsonNews = sharedPref.getString(newsId.toString(),"")

        return gson.fromJson(jsonNews, News::class.java)
    }
    fun setNewsList(newsList: MutableList<News>){
        newsList
    }

    fun findAll() : MutableList<News>{
        return mutableListOf()
    }
}