package com.crismperez.aad.ut01.ex05.data.local

import android.content.SharedPreferences
import com.crismperez.aad.ut01.ex05.domain.User
import com.google.gson.Gson

class UsersLocalDataSource (val sharedPref:SharedPreferences){

    fun saveUsers(users: List<User>){
        val gson = Gson()
        val jsonUser = gson.toJson(users, User::class.java)
        val editor = sharedPref.edit()



    }

    fun getUsers() : List<User>? {
        return emptyList()
    }

    fun findById(userId : Int): User{
        val gson = Gson()

        val jsonUser = sharedPref.getString(userId.toString(),"")

        return gson.fromJson(jsonUser, User::class.java)

    }

    fun remove(userId: Int){

    }
}