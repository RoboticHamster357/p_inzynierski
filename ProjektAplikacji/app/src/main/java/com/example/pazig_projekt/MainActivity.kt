package com.example.pazig_projekt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.pazig_projekt.diary.DiaryActivity
import com.example.pazig_projekt.dog.DogListActivity
import com.example.pazig_projekt.food.FoodList
import com.example.pazig_projekt.products.ProductusActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonDogs.setOnClickListener{
            val intent=Intent(this, DogListActivity::class.java)
            startActivity(intent)
        }
        buttonFood.setOnClickListener{
            val intent=Intent(this, FoodList::class.java)
            startActivity(intent)
        }
        buttonGuide.setOnClickListener{
            val intent=Intent(this, ProductusActivity::class.java)
            startActivity(intent)
        }

        buttonCalendar.setOnClickListener{
            val intent=Intent(this, DiaryActivity::class.java)
            startActivity(intent)
        }

    }
}
