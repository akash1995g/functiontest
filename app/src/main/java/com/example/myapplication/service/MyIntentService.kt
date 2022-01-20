package com.example.myapplication.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.example.myapplication.notification.NotificationHandler

private const val TAG = "MyIntentService"

class MyIntentService : IntentService("Service") {
    override fun onHandleIntent(p0: Intent?) {
        Log.d(TAG, "onHandleIntent: " + Thread.currentThread().name)
        startForeground(2, NotificationHandler.getNotification(applicationContext))

        doWork()
    }

    private fun doWork() {
        while (true) {
            try {
                Log.d(TAG, "doWork: ")
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                Log.d(TAG, "doWork: " + e.message)
            }

        }
    }
}