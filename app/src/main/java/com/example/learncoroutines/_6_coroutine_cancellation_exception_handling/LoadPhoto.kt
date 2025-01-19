package com.example.learncoroutines._6_coroutine_cancellation_exception_handling

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

fun main() = runBlocking {
    val job = launch {
        try {
            println("Bắt đầu tải ảnh...")
            repeat(5) { i ->
                delay(1000)
                println("Đã tải xong ảnh $i")
            }
            println("Hoàn tất tải ảnh!")
        } catch (e: CancellationException) {
            println("Tải ảnh đã bị hủy.")
        } finally {
            println("Dọn dẹp tài nguyên sau khi hủy.")
        }
    }

    delay(3000)
    println("Người dùng nhấn nút Hủy, dừng tải ảnh...")
    job.cancel()
    job.join()
    println("Quá trình kết thúc.")
}