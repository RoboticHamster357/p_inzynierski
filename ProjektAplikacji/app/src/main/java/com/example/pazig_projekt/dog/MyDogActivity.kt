package com.example.pazig_projekt.dog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_my_dog.*
import kotlin.math.pow
import kotlin.math.roundToInt

class MyDogActivity : AppCompatActivity() {

    var dbHendler: DatabaseHandler?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dog)
        val my_dog_id:String = intent.getStringExtra("id")

        val textid=findViewById<TextView>(R.id.tv_dog_calories)
        textid.text=my_dog_id

        dbHendler= DatabaseHandler(this)
        val myDog=dbHendler!!.getOneDog(my_dog_id)
        val name=myDog.name
        val bodyWeight=myDog.bodyWeight
        val age=myDog.age
        val ageUnit=myDog.ageUnit
        val physicalActivity=myDog.physicalActivity
        val breed=myDog.breed
        val overweight=myDog.overweight
        val sterilization=myDog.sterilization

        val textName=findViewById<TextView>(R.id.tv_dog_name)
        textName.text=name

        dbHendler= DatabaseHandler(this)
        val foodKinds=dbHendler!!.getAllFood()
        val nrOfFoodKinds=foodKinds.size
        var strFoodNames=""
        for (i in 0..nrOfFoodKinds-1){
            strFoodNames=strFoodNames+ foodKinds[i].foodName+"%"
        }
        var foodNames=strFoodNames.split("%").toTypedArray()
        foodNames=foodNames.dropLast(1).toTypedArray()
        val spinnerFood = findViewById<Spinner>(R.id.spinner_food)
        createSpinner(foodNames,spinnerFood)



        fun calculateDailyCalorieNeeds():Double{
            var dailyCalorieNeeds=0.0
            val RER = 70 * bodyWeight.pow(0.75)
            if (ageUnit == "Miesiecy")
            {
                if(breed=="Mała")
                {
                    if(age<4)
                    {
                        dailyCalorieNeeds=3*RER
                    }
                    else if(age<6)
                    {
                        dailyCalorieNeeds=2.5*RER
                    }
                    else if(age<9)
                    {
                        dailyCalorieNeeds=2*RER
                    }
                    else if(age>=9)
                    {
                        dailyCalorieNeeds=1.8*RER
                    }
                }
                else if(breed=="Średnia")
                {
                    if(age<5)
                    {
                        dailyCalorieNeeds=3*RER
                    }
                    else if(age<8)
                    {
                        dailyCalorieNeeds=2.5*RER
                    }
                    else if(age<12)
                    {
                        dailyCalorieNeeds=2*RER
                    }
                    else if(age>=12)
                    {
                        dailyCalorieNeeds=1.8*RER
                    }
                }
                else if(breed=="Duża")
                {
                    if(age<5)
                    {
                        dailyCalorieNeeds=3*RER
                    }
                    else if(age<10)
                    {
                        dailyCalorieNeeds=2.5*RER
                    }
                    else if(age<18)
                    {
                        dailyCalorieNeeds=2*RER
                    }
                    else if(age>=18)
                    {
                        dailyCalorieNeeds=1.8*RER
                    }
                }
                else if(breed=="Olbrzymia")
                {
                    if(age<5)
                    {
                        dailyCalorieNeeds=3*RER
                    }
                    else if(age<12)
                    {
                        dailyCalorieNeeds=2.5*RER
                    }
                    else if(age<21)
                    {
                        dailyCalorieNeeds=2*RER
                    }
                    else if(age>=21)
                    {
                        dailyCalorieNeeds=1.8*RER
                    }
                }
            }
            else {
                if ((breed == "Mała" && age < 9) || (breed == "Średnia"&&age<8) || (breed == "Duża" && age<7) || (breed == "Olbrzymia" && age<5)) {
                    if (physicalActivity == "Niska")
                    {
                        dailyCalorieNeeds=RER*1.4

                    } else if (physicalActivity == "Umiarkowana") {
                        if(sterilization=="Tak")
                        {
                            dailyCalorieNeeds=RER*1.6
                        }
                        else
                        {
                            dailyCalorieNeeds=RER*1.8
                        }
                    } else if (physicalActivity == "Pies pracujący/trenujący lekko")
                    {
                        dailyCalorieNeeds = RER * 2
                    } else if (physicalActivity == "Pies pracujący/trenujący średnio")
                    {
                        dailyCalorieNeeds = RER * 3

                    } else if (physicalActivity == "Pies pracujący/trenujący ciężko")
                    {
                        dailyCalorieNeeds = RER * 6

                    }
                }
                else{
                    if(overweight=="Tak")
                    {
                        dailyCalorieNeeds=RER*1.2
                    }
                    else if(overweight=="Nie")
                    {
                        dailyCalorieNeeds=RER*1.4
                    }

                }
            }

            return dailyCalorieNeeds
        }

        val textCalories=findViewById<TextView>(R.id.tv_dog_calories)
        textCalories.text=calculateDailyCalorieNeeds().roundToInt().toString()+" kcal/dzień"

        var calorific=0.0
        var gramsOfFood=0.0


        spinnerFood.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val thisFooodName= spinnerFood.selectedItem.toString()
                for (i in 0..nrOfFoodKinds-1){
                    if(foodKinds[i].foodName==thisFooodName)
                    {
                        calorific= foodKinds[i].foodCalorific
                    }
                }
                gramsOfFood=(calculateDailyCalorieNeeds()/calorific)*100
                val textGrams=findViewById<TextView>(R.id.tv_grams_of_food)
                textGrams.text=gramsOfFood.roundToInt().toString()+" g"
            }

        }
        var diary = getDogFromDatabase(my_dog_id)
        rv_dog_diary.layoutManager = LinearLayoutManager(this)

        val adapter = DiaryDogAdapter(diary, this)
        rv_dog_diary.adapter = adapter
    }
    private fun getDogFromDatabase(thisDodID:String): ArrayList<SpecificDogDiary> {
        dbHendler = DatabaseHandler(this)
        var diary = dbHendler!!.getSpecificDogDiary(thisDodID)
        return diary
    }
    private fun createSpinner(contentArray: Array<String>, spinner: Spinner) {
            val arrayAdapterGender = ArrayAdapter(this, android.R.layout.simple_spinner_item, contentArray)
            spinner.adapter = arrayAdapterGender

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
    }
    class DogInformation (val id : String,val name:String,val bodyWeight:Double,val gender:String, val age:Int, val ageUnit:String, val overweight:String,val slimming:String,val physicalActivity:String,val sterilization:String,val breed:String)

class SpecificDogDiary(
    val diaryID: String,
    val yaer:Int,
    val month:Int,
    val day:Int,
    val dogReaction:Int,
    val description: String,
    val foodName:String)
}


