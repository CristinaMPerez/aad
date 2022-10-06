package com.crismperez.aad.ut01.ex05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.crismperez.aad.R
import com.crismperez.aad.ut01.ex05.data.UsersRepository
import com.crismperez.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.crismperez.aad.ut01.ex05.data.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex05)

        init()

    }

    private fun init(){

        val usersRepository = UsersRepository(
            UsersLocalDataSource(), UsersRemoteDataSource()
        )

        val users = usersRepository.getUsers()
        Log.d("@dev", "Users: $users")
    }
}