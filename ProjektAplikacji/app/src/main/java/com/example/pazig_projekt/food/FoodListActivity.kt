package com.example.pazig_projekt.food

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_dogs_list.*

class FoodList: AppCompatActivity() {

    var dbHendler: DatabaseHandler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs_list)
        var food = getFoodFromDatabase()


        rv_dogs_list.layoutManager = LinearLayoutManager(this)

        val adapter = FoodAdapter(food, this)
        rv_dogs_list.adapter = adapter

        val actionButton = findViewById<FloatingActionButton>(R.id.buttonNewDog)

        actionButton.setOnClickListener {
            val intent = Intent(this, NewFoodActivity::class.java)
            startActivity(intent)
        }

        tv_title.text="JEDZENIE"


    }

    private fun getFoodFromDatabase(): ArrayList<FoodName> {
    dbHendler = DatabaseHandler(this)
    var food = dbHendler!!.getFoodNames()
    return food
}

class FoodName(val id: String, val name: String)
}
