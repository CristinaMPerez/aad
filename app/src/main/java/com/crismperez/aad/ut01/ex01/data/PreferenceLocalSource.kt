package com.crismperez.aad.ut01.ex01.data

import android.app.Activity
import android.content.Context
import com.crismperez.aad.ut01.ex01.domain.Customer

class PreferenceLocalSource (private val activity: Activity) {

    val sharedPref = activity.getPreferences(
        Context.MODE_PRIVATE
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

    fun getCustomer() : Customer {
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe")!!, //La doble exclamacion ignora el nulo
            sharedPref.getString("surname", "no existe") ?: "no existe",// si no se cumple lo que hay en parentesis se ejecuta lo de despues
            sharedPref.getBoolean("is_active", true)
        )

    }

}