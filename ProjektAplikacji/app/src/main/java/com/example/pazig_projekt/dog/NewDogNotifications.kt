package com.example.pazig_projekt.dog


import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import com.example.pazig_projekt.R
import com.example.pazig_projekt.notifications.AlertReceiver
import com.example.pazig_projekt.notifications.TimePickerFragment
import kotlinx.android.synthetic.main.activity_new_dog_notifications.*
import java.text.DateFormat
import java.util.*


class NewDogNotifications : AppCompatActivity(),TimePickerDialog.OnTimeSetListener {


    private var mTextView:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_dog_notifications)

        mTextView = findViewById(R.id.textView)

        val buttonTimePicker = findViewById<Button>(R.id.button_timepicker)
        buttonTimePicker.setOnClickListener {
            val timePicker = TimePickerFragment()
            timePicker.show(supportFragmentManager, "time picker")



            val buttonCancelAlarm = findViewById<Button>(R.id.button_cancel)
            buttonCancelAlarm.setOnClickListener{
                cancelAlarm()
            }
        }
        button_confirm.setOnClickListener{
            val intent= Intent(this, DogListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val c = Calendar.getInstance()
        c.set(Calendar.HOUR_OF_DAY, hourOfDay)
        c.set(Calendar.MINUTE, minute)
        c.set(Calendar.SECOND, 0)

        updateTimeText(c)
        startAlarm(c)
    }


    private fun updateTimeText(c: Calendar) {
        var timeText = "Powiadomienie ustawione na: "
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime())

        mTextView!!.text = timeText
    }

    private fun startAlarm(c: Calendar) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlertReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1)
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent)
//        alarmManager.setRepeating(
//            AlarmManager.RTC,
//            c.timeInMillis,
//            AlarmManager.INTERVAL_DAY,
//            pendingIntent
//        )
    }

    private fun cancelAlarm() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE ) as AlarmManager

        val intent = Intent(this, AlertReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)

        alarmManager.cancel(pendingIntent)
        mTextView!!.text = "Alarm canceled"
    }
}
