package com.crismperez.aad.ut01.ex02.data

import android.content.Context
import com.crismperez.aad.R
import com.crismperez.aad.ut01.ex02.domain.FirstOpened

class SharedPreference (val context: Context) {

    val SharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_ut01ex02), Context.MODE_PRIVATE
    )

    fun saveFirstOpened(fOpened: FirstOpened) {
        val editor = SharedPref.edit()

        editor.apply {
            putBoolean("entrada", fOpened.contador)
            apply()
        }

    }

    fun getFirstOpened() : FirstOpened{
        return FirstOpened(SharedPref.getBoolean("entrada", true))
    }
}