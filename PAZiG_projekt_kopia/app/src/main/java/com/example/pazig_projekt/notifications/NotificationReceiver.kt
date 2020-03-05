package com.example.pazig_projekt.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.support.v4.app.NotificationCompat
import android.app.PendingIntent
import android.content.Intent
import com.example.pazig_projekt.MainActivity
import android.app.NotificationManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import com.example.pazig_projekt.dog.NewDogNotifications


class NotificationReceiver : BroadcastReceiver() {
    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.example.pazig_projekt.dog"
    private val description = "Test notification"

    override fun onReceive(context: Context?,intent: Intent?) {

        val intent = Intent(context, NewDogNotifications::class.java)
        val pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(context,channelId)
                .setSmallIcon(com.example.pazig_projekt.R.drawable.ic_add_black_24dp)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        context?.resources,
                        com.example.pazig_projekt.R.drawable.ic_favorite_black_24dp))
                .setContentIntent(pendingIntent)
        }else{

            builder = Notification.Builder(context)
                .setSmallIcon(com.example.pazig_projekt.R.drawable.ic_add_black_24dp)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        context?.resources,
                        com.example.pazig_projekt.R.drawable.ic_favorite_black_24dp))
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234,builder.build())

    }
}