package com.crismperez.aad.ut01.ex03
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.crismperez.aad.ut01.ex03.data.NewsLocalSource
import com.crismperez.aad.ut01.ex03.domain.News
import com.crismperez.aad.ut01.ex04.SecureSharedPreferences

class Ut01Ex03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init()
        initWithList()
    }

    private fun init () {
        val newsLocalSource = NewsLocalSource(
            getPreferences(MODE_PRIVATE)
        )
        val news1= News(1, "titulo1","subtitle1", "summary1")
        val news2= News(2, "titulo2","subtitle2", "summary2")
        val news3= News(3, "titulo3","subtitle3", "summary3")
        newsLocalSource.setNews(news1)
        newsLocalSource.setNews(news2)
        newsLocalSource.setNews(news3)
        val newNews1 = newsLocalSource.findByid(2)
        Log.d("@dev", "News: $newNews1")
    }

    private fun initWithList(){
        val newsList: MutableList<News> = mutableListOf<News>()
        val news1= News(1, "titulo1","subtitle1", "summary1")
        val news2= News(2, "titulo2","subtitle2", "summary2")
        val news3= News(3, "titulo3","subtitle3", "summary3")


        val newsLocalSource = NewsLocalSource(
            getPreferences(Context.MODE_PRIVATE)
        )
        newsLocalSource.setNewsList(newsList)
    }

    private fun secure() {
        val secure = SecureSharedPreferences(applicationContext)
        secure.saveNews(News(1,"News1","News1","summary1"))
    }

}