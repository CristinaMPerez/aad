package com.crismperez.aad.ut01.ex05.data.local

import android.content.SharedPreferences
import com.crismperez.aad.ut01.ex05.domain.User
import com.google.gson.Gson

class UsersLocalDataSource (val sharedPref:SharedPreferences){

    private val gson =Gson()

    fun saveUsers(users: List<User>){
        users.forEach{ //Recorre el listado User
            saveUser(it) // guarda un usuario
        }
    }

    fun saveUser(users:User){

        val jsonUser = gson.toJson(users, User::class.java)
        val editor = sharedPref.edit()

        editor.putString(users.id.toString(), jsonUser)
        editor.apply()
    }

    fun getUsers() : List<User> {
        val userList = mutableListOf<User>()
        sharedPref.all.forEach { entry ->
            val users = gson.fromJson(entry.value as String, User::class.java)
            userList.add(users)
        }
        return userList
    }

    fun findById(userId : Int): User?{

        val jsonUser = sharedPref.getString(userId.toString(),"")

        return gson.fromJson(jsonUser, User::class.java)

    }

    fun remove(userId: Int) {
        sharedPref.edit().remove(userId.toString()).apply()
    }
}