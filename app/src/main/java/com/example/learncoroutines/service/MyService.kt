package com.example.learncoroutines.service

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import android.app.Notification
import com.example.learncoroutines.R

class MyService : Service() {

    private val channelId = "ForegroundServiceChannel"
    private val handler = Handler(Looper.getMainLooper())

    private val logRunnable = object : Runnable {
        override fun run() {
            Log.d("TAG=====","running...")
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = createNotification("Service đang chạy...")
        startForeground(1, notification)

        handler.post(logRunnable)

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(logRunnable)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotification(message: String): Notification {
        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("My Service")
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_alarm)
            .build()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
}