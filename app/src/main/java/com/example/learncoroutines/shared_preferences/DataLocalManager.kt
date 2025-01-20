package com.example.learncoroutines.shared_preferences

import android.annotation.SuppressLint
import android.content.Context

object DataLocalManager {
    private const val NAME = "NAME"

    private var instance: DataLocalManager? = null

    @SuppressLint("StaticFieldLeak")
    private var mySharedPreferences : MySharedPreferences? = null

    fun init(context: Context) {
        instance = DataLocalManager
        mySharedPreferences = MySharedPreferences(context)
    }

    fun setName(name : String) {
        mySharedPreferences?.putString(NAME, name)
    }

    fun getName(): String {
        return mySharedPreferences!!.getString(NAME)
    }


}