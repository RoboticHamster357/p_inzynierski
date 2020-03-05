package com.example.pazig_projekt.dog

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.activity_new_dog.*
import kotlin.math.roundToInt

class NewDogActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_dog)


        val genderArray = arrayOf("Samica", "Samiec")
        val spinnerGender = findViewById<Spinner>(R.id.spinner_gender)
        createSpinner(genderArray, spinnerGender)



        val ageUnitArray = arrayOf("Miesięcy", "Lat")
        val spinnerAgeUnit = findViewById<Spinner>(R.id.spinner_age_unit)
        createSpinner(ageUnitArray, spinnerAgeUnit)


        val activityLevelArray = arrayOf(
            "Niska",
            "Umiarkowana",
            "Pies pracujący/trenujący lekko",
            "Pies pracujący/trenujący średnio",
            "Pies pracujący/trenujący ciężko"
        )
        val spinnerActivityLevel = findViewById<Spinner>(R.id.spinner_activity)
        createSpinner(activityLevelArray, spinnerActivityLevel)

        val sterilizationArray = arrayOf("Tak", "Nie")
        val spinnerSterilization = findViewById<Spinner>(R.id.spinner_sterilization)
        createSpinner(sterilizationArray, spinnerSterilization)

        val breedArray = arrayOf("Mała", "Średnia", "Duża", "Olbrzymia")
        val spinnerBreed = findViewById<Spinner>(R.id.spinner_breed)
        createSpinner(breedArray, spinnerBreed)


        button_next.setOnClickListener(View.OnClickListener {
            if (validation()) {
                val age=edit_text_age.text.toString().toDouble().roundToInt()
                val extras =  Bundle()
                extras.putString("name",edit_text_name.text.toString())
                extras.putDouble("bodyWeight",edit_text_weight.text.toString().toDouble())
                extras.putString("gender",spinnerGender.selectedItem.toString())
                extras.putInt("age",age)
                extras.putString("ageUnit",spinner_age_unit.selectedItem.toString())
                extras.putString("physicalActivity",spinnerActivityLevel.selectedItem.toString())
                extras.putString("sterilization",spinnerSterilization.selectedItem.toString())
                extras.putString("breed",spinnerBreed.selectedItem.toString())
                val intent=Intent(this, NewDogBodyConditionScore::class.java)
                intent.putExtras(extras)
                startActivity(intent)

            }
        })


    }

    private fun validation(): Boolean {
        var validate = false

        if (!edit_text_name.text.toString().equals("") &&
            !edit_text_weight.text.toString().equals("")&&
            !edit_text_age.text.toString().equals("")
        ) {
            validate = true
        } else {
            validate = false
            Toast.makeText(this, "Wypełnij wszystkie pola", Toast.LENGTH_LONG).show()
        }

        return validate
    }

    private fun createSpinner(contentArray: Array<String>, spinner: Spinner) {
        if (spinner != null) {
            val arrayAdapterGender = ArrayAdapter(this, android.R.layout.simple_spinner_item, contentArray)
            spinner.adapter = arrayAdapterGender

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }

}












