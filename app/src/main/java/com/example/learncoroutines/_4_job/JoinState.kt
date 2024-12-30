package com.example.learncoroutines._4_job

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("Job is running $i ...")
            delay(500L)
        }
    }
    delay(1500L)
    println("Cancelling the job...")
    job.join()
    println("Job is cancelled")
}