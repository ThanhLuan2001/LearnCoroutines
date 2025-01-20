package com.example.learncoroutines.shared_preferences

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(val context: Context) {

    val PREF = "PREF"

    fun putString(key: String, value: String) {
        val pref: SharedPreferences =
            context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String): String {
        val pref: SharedPreferences =
            context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return pref.getString(key, "").toString()
    }
}