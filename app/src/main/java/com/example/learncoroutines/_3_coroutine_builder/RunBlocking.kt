package com.example.learncoroutines._3_coroutine_builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Start job")
    delay(2000L)
    println("End job")
}