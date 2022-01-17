package com.example.myapplication.ui

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.broadcast.BroadcastReceivers

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btn:Button = findViewById(R.id.btn)

        btn.setOnClickListener {

            this.sendBroadcast(Intent("Sending Message"))

        }
        this.registerReceiver(BroadcastReceivers(), IntentFilter("Sending Message"))


    }
}