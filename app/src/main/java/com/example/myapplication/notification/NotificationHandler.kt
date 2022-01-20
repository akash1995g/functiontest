package com.example.myapplication.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.myapplication.R

class NotificationHandler {

    companion object {

        private const val channelID = "notification"
        fun getNotification(context: Context): Notification? {
            val notificationHandler = NotificationCompat.Builder(context, channelID)
            val notification = notificationHandler.setContentTitle("Notification Title")
                .setContentText("Notification message")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(false)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel(context)
            }
            return notification

        }

        @RequiresApi(Build.VERSION_CODES.O)
        private fun createNotificationChannel(context: Context) {

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


            val channel = NotificationChannel(
                channelID,
                "Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                this.description = "Notification Message"
            }

            notificationManager.createNotificationChannel(channel)

        }

    }
}