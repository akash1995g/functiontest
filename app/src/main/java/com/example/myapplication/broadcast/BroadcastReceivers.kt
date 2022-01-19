package com.example.myapplication.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService.enqueueWork
import com.example.myapplication.service.MyJobIntentService

private const val TAG = "BroadcastReceivers"

class BroadcastReceivers : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d(TAG, "onReceive: ")

        if (p0 != null) {
            //MyService.enqueueWork(p0, Intent(p0, MyService::class.java))
            enqueueWork(p0,MyJobIntentService::class.java,2,Intent(p0,MyJobIntentService::class.java))
        }

    }
}