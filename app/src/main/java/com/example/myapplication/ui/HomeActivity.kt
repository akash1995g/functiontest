package com.example.myapplication.ui

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.broadcast.BroadcastReceivers
import com.example.myapplication.service.MyIntentService
import com.example.myapplication.service.MyService

/**
 * Service is used to create a background service in Main thread
 * IntentService is used to create a background service in worker thread
 *
 * */

class HomeActivity : AppCompatActivity() {

    private val intentFilter = IntentFilter("Sending Message")
    private val broadcastReceivers = BroadcastReceivers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val serviceBtn: Button = findViewById(R.id.start_service)

        serviceBtn.setOnClickListener {

            // this.sendBroadcast(Intent("Sending Message"))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this, MyService::class.java))
            } else {
                startService(Intent(this, MyService::class.java))
            }

        }
        this.registerReceiver(broadcastReceivers, intentFilter)

        val intentServiceBtn: Button = findViewById(R.id.start_intent_service)

        intentServiceBtn.setOnClickListener {

            // this.sendBroadcast(Intent("Sending Message"))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this, MyIntentService::class.java))
            } else {
                startService(Intent(this, MyIntentService::class.java))
            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceivers)
    }

}