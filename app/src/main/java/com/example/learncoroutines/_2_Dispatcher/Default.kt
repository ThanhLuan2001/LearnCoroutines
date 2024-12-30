package com.example.learncoroutines._2_Dispatcher

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {

    val numbers = List(1000) { (1..1_000).random() }

    println("Danh sách trước khi sắp xếp")

    for (item in numbers){
        println("Item : $item")
    }

    val sortedNumbers = CoroutineScope(Dispatchers.Default).async {
        numbers.sorted()
    }


    val result = sortedNumbers.await()

    println("Danh sách sau khi sắp xếp")

    for (item in result){
        println("Item : $item")
    }

}