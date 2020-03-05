package com.example.pazig_projekt.notifications

import android.app.TimePickerDialog
import android.widget.TimePicker
import java.util.*

class TimePicker {
    val cal=Calendar.getInstance()
    val timeSetListener=TimePickerDialog.OnTimeSetListener{timePicker: TimePicker?, hour: Int, minute: Int ->
        cal.set(Calendar.HOUR_OF_DAY,hour)
        cal.set(Calendar.MINUTE,minute)

    }
}