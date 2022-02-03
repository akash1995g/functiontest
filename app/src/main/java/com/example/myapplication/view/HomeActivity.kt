package com.example.myapplication.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.notification.NotificationHandler

class HomeActivity : AppCompatActivity() {
    var count =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    fun clicked(view: View) {
        NotificationHandler.createNotification(this,R.drawable.ic_launcher_background,
        Intent(this, HomeActivity::class.java),
            count++
        )
    }
}