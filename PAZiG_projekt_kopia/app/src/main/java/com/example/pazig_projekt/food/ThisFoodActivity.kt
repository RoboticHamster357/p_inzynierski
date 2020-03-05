package com.example.pazig_projekt.food

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler

class ThisFoodActivity : AppCompatActivity() {
    var dbHendler: DatabaseHandler?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_this_food)
        val thisFoodID:String = intent.getStringExtra("id")

        dbHendler= DatabaseHandler(this)
        val thisFood=dbHendler!!.getOneFood(thisFoodID)
        val foodName=thisFood.foodName
        val calorific=thisFood.foodCalorific

        val foodDiary=dbHendler!!.getAllDiary()




        val textFoodName=findViewById<TextView>(R.id.tv_food_name)
        textFoodName.text=foodName

        val textFoodCalorific=findViewById<TextView>(R.id.tv_food_calorific)
        textFoodCalorific.text=calorific.toString()+" kcal/100g"
    }
    class FoodInformation (val foodID : String,val foodName:String,val foodCalorific:Double)

class DiaryInformation (val diaryID : String,val yaer:Int,val month:Int,val day:Int,val dogName:String, val foodName:String,val dogReaction:Int,val description:String)
}

