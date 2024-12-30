package com.example.learncoroutines._3_coroutine_builder

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("Hello")
    }

    println("World")
    Thread.sleep(1500L)
}