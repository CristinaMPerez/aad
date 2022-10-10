package com.crismperez.aad.ut01.ex05.data

import com.crismperez.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.crismperez.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.crismperez.aad.ut01.ex05.domain.User

class UsersRepository(val localSource: UsersLocalDataSource,
                      val remoteSource: UsersRemoteDataSource) {

    fun getUsers(): List<User>{

       var users = localSource.getUsers()
        if (users == null){
            users = remoteSource.getUser()
            localSource.saveUsers(users)
        }
        return users
    }

    fun getUserById (userId : Int) :User{
        var user = localSource.findById(userId)
            if(user == null){
                user = remoteSource.getUsers(userId)
            }
        return user

    }

    fun removeUser (userId: Int){


    }
}