package com.crismperez.aad.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.crismperez.aad.R
import com.crismperez.aad.ut01.ex01.data.SharedPreferencesLocalSource
import com.crismperez.aad.ut01.ex02.data.SharedPreference
import com.crismperez.aad.ut01.ex02.domain.FirstOpened


class Ut01Ex02Activity : AppCompatActivity() {
    //saber cuando la aplicacion es la primera vez que se abre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02)

        initSharedPreferences()

    }

    private fun initSharedPreferences() {


        val spFirstOpened = SharedPreference(this)
        spFirstOpened.saveFirstOpened(FirstOpened(true))
        comprobacion(spFirstOpened.getFirstOpened())

    }
    private fun comprobacion (first: FirstOpened) {
        if (first.contador) {
            Log.d("@dev", "es la primera entrada ${first.contador}")
        } else {
            Log.d("@dev", "no es la primera entrada ${first.contador}")
        }
    }
}







