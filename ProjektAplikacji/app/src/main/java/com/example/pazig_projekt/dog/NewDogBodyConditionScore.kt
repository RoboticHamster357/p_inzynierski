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
    var bodyCS=0
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
                val intent= Intent(this, MyDogBodyConditionScore::class.java)
                val extras =  Bundle()
                extras.putString("bodyCS",bodyCS.toString())
                intent.putExtras(extras)


                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"nic nie zostało wybrane",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun radioButtonClick(view: View){
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Wybrano sylwetkę",
            Toast.LENGTH_SHORT).show()
    }
    private fun onRadioButtonClicked(view: View) {
        var checked = view as RadioButton
        if (s_1 == checked) {
            overweight="Nie"
            slimming="Nie"
            bodyCS=1
           // Toast.makeText(applicationContext,"wybrałes",
            //    Toast.LENGTH_SHORT).show()
        }
        if (s_2 == checked) {
            overweight="Nie"
            slimming="Nie"
            bodyCS=2
        }

        if (s_3 == checked) {
            overweight="Nie"
            slimming="Nie"
            bodyCS=3
        }
        if (s_4 == checked) {
            overweight="Nie"
            slimming="Nie"
            bodyCS=4
        }
        if (s_5 == checked) {
            overweight="Nie"
            slimming="Nie"
            bodyCS=5
        }
        if (s_6 == checked) {
            overweight="Tak"
            slimming="Nie"
            bodyCS=6
        }
        if(s_7==checked){
            overweight="Tak"
            slimming="Tak"
            bodyCS=7
        }
        if(s_8==checked){
            overweight="Tak"
            slimming="Tak"
            bodyCS=8
        }
        if(s_9==checked){
            overweight="Tak"
            slimming="Tak"
            bodyCS=9
        }
    }
}
