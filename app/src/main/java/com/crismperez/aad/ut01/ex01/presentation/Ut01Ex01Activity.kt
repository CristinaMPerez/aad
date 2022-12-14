package com.crismperez.aad.ut01.ex01.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.crismperez.aad.R
import com.crismperez.aad.ut01.ex01.data.PreferenceLocalSource
import com.crismperez.aad.ut01.ex01.data.SharedPreferencesLocalSource
import com.crismperez.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
        initPreferences()
    }

    private fun initSharedPreferences(){

        //val spCustomer: SharedPreferencesLocalSource = SharedPreferencesLocalSource(this)
        val spCustomer = SharedPreferencesLocalSource(this)
        spCustomer.saveCustomer(Customer(2, "Customer2", "Surname2", true))

        ContextCompat.getColor(this, R.color.black)


        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer")
    }

    private fun initPreferences(){

        //val spCustomer: PreferenceLocalSource = SharedPreferencesLocalSource(this)
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1, "Customer1", "Surname1", true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer")
    }
}