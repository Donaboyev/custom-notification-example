package com.donaboyev.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import com.donaboyev.app.Util.NOTIFICATION_ID

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Today important tasks", Toast.LENGTH_SHORT).show()
        val notificationManager = NotificationManagerCompat.from(context!!)
        notificationManager.cancel(NOTIFICATION_ID)
    }

}