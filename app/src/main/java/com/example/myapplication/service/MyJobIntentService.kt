package com.example.myapplication.service

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService
import java.lang.Exception

private const val TAG = "MyService"

// JobService
// Service
// IntentService

class MyJobIntentService : JobIntentService() {

    companion object {
        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, MyJobIntentService::class.java, 1, intent)

        }
    }

    override fun onHandleWork(intent: Intent) {

        Log.d(TAG, "onHandleWork: " + Thread.currentThread().name)
        Thread(Runnable {
            try {
                Log.d(TAG, "onHandleWork: logging")
                Thread.sleep(1_000)
            } catch (e: Exception) {
                Log.d(TAG, "onHandleWork: " + e.message)
            }
        }).start()

    }

}