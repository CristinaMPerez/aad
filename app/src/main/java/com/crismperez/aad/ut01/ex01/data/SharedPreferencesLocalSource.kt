package com.crismperez.aad.ut01.ex01.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.crismperez.aad.R
import com.crismperez.aad.ut01.ex01.domain.Customer

class SharedPreferencesLocalSource (val context: Context){

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE
    )

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()

        //Kotlin Style
        editor.apply{
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.isActive)
            apply()

        //Java Style
        /*editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)
        editor.apply() //asíncrono escribe con otro hilo
        //editor.commit() síncrono el mismo hilo escribe*/

        }

    }

    fun getCustomer() : Customer{
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe")!!, //La doble exclamacion ignora el nulo
            sharedPref.getString("surname", "no existe") ?: "no existe",// si no se cumple lo que hay en parentesis se ejecuta lo de despues
            sharedPref.getBoolean("is_active", true)
        )

    }

}