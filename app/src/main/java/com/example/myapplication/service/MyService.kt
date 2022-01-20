package com.example.myapplication.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.myapplication.notification.NotificationHandler

private const val TAG = "MyService"

class MyService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d(TAG, "onStartCommand: ")
        startForeground(1, NotificationHandler.getNotification(applicationContext))

        doWork()

        return super.onStartCommand(intent, flags, startId)
    }

    private fun doWork() {
        Thread(Runnable {
            while (true)
                try {
                    Log.d(TAG, "doWork: ")
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    Log.d(TAG, "doWork: " + e.message)
                }
        }).start()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}