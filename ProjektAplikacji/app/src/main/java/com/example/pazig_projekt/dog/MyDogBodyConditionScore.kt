package com.example.pazig_projekt.dog

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.activity_my_dog_body_condition_score.*

class MyDogBodyConditionScore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dog_body_condition_score)

        val intent = intent
        val extras = intent.extras
        var bodyCS = extras!!.getString("bodyCS")
        var intBodyCS=bodyCS.toInt()
        rateBodyCondition(intBodyCS)


        button_ok.setOnClickListener{
            val intent=Intent(this, QuestionNotificaton::class.java)
            startActivity(intent)
        }
    }
    private fun rateBodyCondition(intBodyCS:Int){
        if (intBodyCS==1)
        {
            tv_body_CS.text="Twój pies jest wychudzony!"
        }
        if(intBodyCS==2)
        {
            tv_body_CS.text="Twój pies ma znaczną niedowagę!"
        }
        if(intBodyCS==3)
        {
            tv_body_CS.text="Twój pies ma niedowagę."
        }
        if (intBodyCS==4)
        {
            tv_body_CS.text="Twój pies jest szczupły."
        }
        if(intBodyCS==5)
        {
            tv_body_CS.text="Twój pies ma idealną masę ciała. Brawo!"
        }
        if(intBodyCS==6)
        {
            tv_body_CS.text="Twój pies ma niewielką nadwagę."
        }
        if(intBodyCS==7)
        {
            tv_body_CS.text="Twój pies ma poważną nadwagę"
        }
        if(intBodyCS==8)
        {
            tv_body_CS.text="Twój pies jest otyły!"
        }
        if(intBodyCS==9)
        {
            tv_body_CS.text="Twój pies ma poważną otyłość!"
        }

    }
}
