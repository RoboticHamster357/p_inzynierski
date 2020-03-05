package com.example.pazig_projekt.food

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler
import com.example.pazig_projekt.database.model.Food
import kotlinx.android.synthetic.main.activity_new_food.*

class NewFoodActivity : AppCompatActivity() {

    var dbHendler: DatabaseHandler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_food)
        dbHendler = DatabaseHandler(this)

        button_save.setOnClickListener(View.OnClickListener {

                val food: Food = Food()
                var success: Boolean = false
                food.food_name = edit_text_name.text.toString()
                food.food_calorific = edit_text_calories.text.toString().toInt()

                success = dbHendler!!.addFood(food)
                if (success) {
                    Toast.makeText(this, "Dodano jedzenie", Toast.LENGTH_LONG).show()
                }
        })

    }

}
