package com.example.pazig_projekt.dog

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler
import com.example.pazig_projekt.database.model.Dog
import kotlinx.android.synthetic.main.activity_new_dog_body_condition_score.*




class NewDogBodyConditionScore : AppCompatActivity() {

    var dbHendler: DatabaseHandler? = null
    var overweight =""
    var slimming=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_dog_body_condition_score)
        val intent = intent
        val extras = intent.extras
        val name = extras!!.getString("name")
        val bodyWeight = extras.getDouble("bodyWeight")
        val gender=extras.getString("gender")
        val age=extras.getInt("age")
        val ageUnit=extras.getString("ageUnit")
        val physicalActivity=extras.getString("physicalActivity")
        val sterilization=extras.getString("sterilization")
        val breed=extras.getString("breed")

        dbHendler = DatabaseHandler(this)

        button.setOnClickListener{
            var id: Int = radio_group.checkedRadioButtonId
            val radioButton: RadioButton = findViewById(radio_group.checkedRadioButtonId)

            if (id!=-1){
                onRadioButtonClicked(radioButton)
                val dog: Dog = Dog()
                var success: Boolean = false
                dog.name = name
                dog.bodyWeight = bodyWeight
                dog.gender = gender
                dog.age = age
                dog.ageUnit = ageUnit
                dog.overweight = overweight
                dog.slimming = slimming
                dog.physicalActivity = physicalActivity
                dog.sterilization = sterilization
                dog.breed = breed
                success = dbHendler!!.addDog(dog)
                if (success) {
                    Toast.makeText(this, "Dodano psa", Toast.LENGTH_LONG).show()
                 }
                val intent= Intent(this, QuestionNotificaton::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"nic nie zostało wybrane",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun radioButtonClick(view: View){
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }
    private fun onRadioButtonClicked(view: View) {
        var checked = view as RadioButton
        if (s_1 == checked) {
            overweight="Nie"
            slimming="Nie"
            Toast.makeText(applicationContext,"wybrałes",
                Toast.LENGTH_SHORT).show()
        }
        if (s_2 == checked) {
            overweight="Nie"
            slimming="Nie"
        }

        if (s_3 == checked) {
            overweight="Nie"
            slimming="Nie"
        }
        if (s_4 == checked) {
            overweight="Nie"
            slimming="Nie"
        }
        if (s_5 == checked) {
            overweight="Nie"
            slimming="Nie"
        }
        if (s_6 == checked) {
            overweight="Tak"
            slimming="Nie"
        }
        if(s_7==checked){
            overweight="Tak"
            slimming="Tak"
        }
        if(s_8==checked){
            overweight="Tak"
            slimming="Tak"
        }
        if(s_9==checked){
            overweight="Tak"
            slimming="Tak"
        }
    }
}
