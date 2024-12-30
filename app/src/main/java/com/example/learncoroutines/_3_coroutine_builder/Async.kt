package com.example.learncoroutines._3_coroutine_builder

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun fetchDataInParallel() {
    CoroutineScope(Dispatchers.IO).launch {
        val deferred1 = async { fetchDataFromServer1() }
        val deferred2 = async { fetchDataFromServer2() }

        val result1 = deferred1.await()
        val result2 = deferred2.await()

        withContext(Dispatchers.Main) {
            updateUI(result1, result2)
        }
    }
}

suspend fun fetchDataFromServer1(): String {
    delay(1000L)
    return "Dũ liệu 1"
}

suspend fun fetchDataFromServer2(): String {
    delay(1500L)
    return "Dũ liệu 2"
}

fun updateUI(data1: String, data2: String) {
    //tvData1.text = data1
    //tvData2.text = data2
}