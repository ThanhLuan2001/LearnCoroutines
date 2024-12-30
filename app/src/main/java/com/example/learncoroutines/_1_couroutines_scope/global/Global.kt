package com.example.learncoroutines._1_couroutines_scope.global

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


object Global {
    fun runGlobal(){
        GlobalScope.launch {
            while (true) {
                try {
                    val data = fetchDataFromServer()
                    Log.d("GlobalScope", "Dữ liệu lấy được : $data")
                } catch (e: Exception) {
                    Log.e("GlobalScope", "Lỗi - ${e.message}")
                }
                delay(10000L)
            }
        }
    }

    private suspend fun fetchDataFromServer(): String {
        delay(2000L)
        return "PickleBall"
    }
}
