package com.example.pazig_projekt.dog

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.activity_question_notificaton.*

class QuestionNotificaton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_notificaton)

        button_yes.setOnClickListener{
            val intent= Intent(this, NewDogNotifications::class.java)
            startActivity(intent)
        }

        button_no.setOnClickListener{
            val intent= Intent(this, DogListActivity::class.java)
            startActivity(intent)
        }
    }
}
