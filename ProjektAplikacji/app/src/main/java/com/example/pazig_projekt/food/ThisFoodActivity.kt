package com.example.pazig_projekt.food

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler
import com.example.pazig_projekt.diary.DiaryActivity
import com.example.pazig_projekt.diary.DiaryAdapter
import kotlinx.android.synthetic.main.activity_this_food.*

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

        var diary = getDiaryFromDatabase(thisFoodID)
        rv_food_diary.layoutManager = LinearLayoutManager(this)

        val adapter = DiaryFoodAdapter(diary, this)
        rv_food_diary.adapter = adapter


        val textFoodName=findViewById<TextView>(R.id.tv_food_name)
        textFoodName.text=foodName

        val textFoodCalorific=findViewById<TextView>(R.id.tv_food_calorific)
        textFoodCalorific.text=calorific.toString()+" kcal/100g"
    }
    private fun getDiaryFromDatabase(thisFoodID:String): ArrayList<SpecificFoodDiary> {
        dbHendler = DatabaseHandler(this)
        var diary = dbHendler!!.getSpecificFoodDiary(thisFoodID)
        return diary
    }
    class FoodInformation (val foodID : String,val foodName:String,val foodCalorific:Double)
    class SpecificFoodDiary(
        val diaryID: String,
        val yaer:Int,
        val month:Int,
        val day:Int,
        val dogReaction:Int,
        val description: String,
        val dogName:String)
}


