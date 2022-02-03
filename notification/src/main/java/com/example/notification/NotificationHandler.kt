package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class NotificationHandler {

    companion object {

        private const val Channel_ID = "Channel 1"

        fun createNotification(context: Context, imageResource: Int, intent: Intent, count: Int) {

            val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.getActivity(context, 2, intent, PendingIntent.FLAG_IMMUTABLE)
            } else {
                PendingIntent.getActivity(context, 2, intent, 0)
            }

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val notification = NotificationCompat.Builder(context, Channel_ID).apply {
                this.setContentTitle("OK")
                this.setContentText("Notification Test")
                this.priority = NotificationCompat.PRIORITY_HIGH
                this.setSmallIcon(imageResource)
                this.setContentIntent(pendingIntent)
                this.addAction(imageResource, "Reply", pendingIntent)
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel(notificationManager, notification, count)
            }

            // different id will create different
            notificationManager.notify(0, notification.build())

        }

        @RequiresApi(Build.VERSION_CODES.O)
        private fun notificationChannel(
            notificationManager: NotificationManager,
            notification: NotificationCompat.Builder,
            count: Int
        ) {
            val id = "Test" + count

            val notificationChannel =
                NotificationChannel(id, "channel", NotificationManager.IMPORTANCE_DEFAULT)
                    .apply {
                        this.description = "Channel Description"
                    }
            notificationManager.createNotificationChannel(notificationChannel)
            notification.setChannelId(id)

        }
    }

}