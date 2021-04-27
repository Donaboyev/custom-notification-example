package com.donaboyev.app

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.RemoteViews
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.donaboyev.app.Util.CHANNEL_ID
import com.donaboyev.app.Util.NOTIFICATION_ID
import com.donaboyev.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var notificationManager: NotificationManagerCompat
    private var listItems = arrayOf("First","Second","Third","Fourth","Fifth","Sixth","Seventh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notificationManager = NotificationManagerCompat.from(this)
    }

    fun showNotification(view: View) {
        val collapsedView = RemoteViews(packageName, R.layout.notification_collapsed)
        val expandedView = RemoteViews(packageName, R.layout.notification_expanded)

        val clickIntent = Intent(this, NotificationReceiver::class.java)
        val clickPendingIntent = PendingIntent.getBroadcast(this, 0, clickIntent, 0)

        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello world")

        when (listItems.size) {
            0 -> {
                expandedView.setViewVisibility(R.id.tvFirstTitle, GONE)
                expandedView.setViewVisibility(R.id.tvSecondTitle, GONE)
                expandedView.setViewVisibility(R.id.tvThirdTitle, GONE)
                expandedView.setViewVisibility(R.id.tvFourthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvFifthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvMore, VISIBLE)

                expandedView.setTextViewText(R.id.tvMore, "No important tasks for today")
            }
            1 -> {
                expandedView.setViewVisibility(R.id.tvFirstTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvSecondTitle, GONE)
                expandedView.setViewVisibility(R.id.tvThirdTitle, GONE)
                expandedView.setViewVisibility(R.id.tvFourthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvFifthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvMore, GONE)

                expandedView.setTextViewText(R.id.tvFirstTitle, listItems[0])
            }
            2 -> {
                expandedView.setViewVisibility(R.id.tvFirstTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvSecondTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvThirdTitle, GONE)
                expandedView.setViewVisibility(R.id.tvFourthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvFifthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvMore, GONE)

                expandedView.setTextViewText(R.id.tvFirstTitle, listItems[0])
                expandedView.setTextViewText(R.id.tvSecondTitle, listItems[1])
            }
            3 -> {
                expandedView.setViewVisibility(R.id.tvFirstTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvSecondTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvThirdTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvFourthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvFifthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvMore, GONE)

                expandedView.setTextViewText(R.id.tvFirstTitle, listItems[0])
                expandedView.setTextViewText(R.id.tvSecondTitle, listItems[1])
                expandedView.setTextViewText(R.id.tvThirdTitle, listItems[2])
            }
            4 -> {
                expandedView.setViewVisibility(R.id.tvFirstTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvSecondTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvThirdTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvFourthTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvFifthTitle, GONE)
                expandedView.setViewVisibility(R.id.tvMore, GONE)

                expandedView.setTextViewText(R.id.tvFirstTitle, listItems[0])
                expandedView.setTextViewText(R.id.tvSecondTitle, listItems[1])
                expandedView.setTextViewText(R.id.tvThirdTitle, listItems[2])
                expandedView.setTextViewText(R.id.tvFourthTitle, listItems[3])
            }
            5 -> {
                expandedView.setViewVisibility(R.id.tvFirstTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvSecondTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvThirdTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvFourthTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvFifthTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvMore, GONE)

                expandedView.setTextViewText(R.id.tvFirstTitle, listItems[0])
                expandedView.setTextViewText(R.id.tvSecondTitle, listItems[1])
                expandedView.setTextViewText(R.id.tvThirdTitle, listItems[2])
                expandedView.setTextViewText(R.id.tvFourthTitle, listItems[3])
                expandedView.setTextViewText(R.id.tvFifthTitle, listItems[4])
            }
            else -> {
                expandedView.setViewVisibility(R.id.tvFirstTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvSecondTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvThirdTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvFourthTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvFifthTitle, VISIBLE)
                expandedView.setViewVisibility(R.id.tvMore, VISIBLE)

                expandedView.setTextViewText(R.id.tvFirstTitle, listItems[0])
                expandedView.setTextViewText(R.id.tvSecondTitle, listItems[1])
                expandedView.setTextViewText(R.id.tvThirdTitle, listItems[2])
                expandedView.setTextViewText(R.id.tvFourthTitle, listItems[3])
                expandedView.setTextViewText(R.id.tvFifthTitle, listItems[4])
                expandedView.setTextViewText(
                    R.id.tvMore,
                    "You have ${listItems.size - 5} more important tasks in today"
                )
            }
        }
        expandedView.setOnClickPendingIntent(R.id.mainLayout, clickPendingIntent)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_android)
            .setCustomContentView(collapsedView)
            .setCustomBigContentView(expandedView)
            .build()
        notificationManager.notify(NOTIFICATION_ID, notification)
    }
}