package com.example.learncoroutines

import android.app.Application
import com.example.learncoroutines.shared_preferences.DataLocalManager

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        DataLocalManager.init(this)
    }
}