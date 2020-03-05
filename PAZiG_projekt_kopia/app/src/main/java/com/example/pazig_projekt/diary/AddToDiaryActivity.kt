package com.example.pazig_projekt.diary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.pazig_projekt.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_add_to_diary.*
import android.widget.CalendarView.OnDateChangeListener
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.model.Diary
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class AddToDiaryActivity : AppCompatActivity() {
    var dbHendler: DatabaseHandler?=null
    var yearVar:Int=0
    var monthVar:Int=0
    var dayVar:Int=0
    var reactionVar:Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_diary)


        dbHendler= DatabaseHandler(this)
        val foodKinds=dbHendler!!.getAllFood()
        val nrOfFoodKinds=foodKinds.size
        var strFoodNames=""
        for (i in 0 until nrOfFoodKinds){
            strFoodNames=strFoodNames+ foodKinds[i].foodName+"%"
        }
        var foodNames=strFoodNames.split("%").toTypedArray()
        foodNames=foodNames.dropLast(1).toTypedArray()
        val spinnerFood = findViewById<Spinner>(R.id.spinner_food_names)
        createSpinner(foodNames,spinnerFood)


        val allDogs=dbHendler!!.getDogNames()
        val nrOfDogs=allDogs.size
        var strDogNames=""
        for (i in 0 until nrOfDogs){
            strDogNames=strDogNames+ allDogs[i].name+"%"
        }
        var dogNames=strDogNames.split("%").toTypedArray()
        dogNames=dogNames.dropLast(1).toTypedArray()
        val spinnerDogs=findViewById<Spinner>(R.id.spinner_dogs_names)
        createSpinner(dogNames,spinnerDogs)

        spinner_reaction.adapter = CustomSpinnerAdapter(
            this,
            listOf(
                Reaction(R.drawable.ic_smiley_24dp, "Dobrze"),
                Reaction(R.drawable.ic_sad_24dp, "Źle")
            )
        )

        val date = LocalDate.now()
        dayVar=date.dayOfMonth
        monthVar=date.monthValue
        yearVar=date.year

        val calendarView=findViewById<CalendarView>(R.id.calendarView)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            yearVar=year
            monthVar=month+1
            dayVar=dayOfMonth
        }

        spinner_reaction?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position==0)
                {
                    reactionVar=1
                }
                else
                {
                    reactionVar=0
                }

            }
        }

        button_add.setOnClickListener(View.OnClickListener {
        val diary: Diary = Diary()
        var success: Boolean = false
        diary.year = yearVar
        diary.month=monthVar
        diary.day=dayVar
        diary.dogName = spinnerDogs.selectedItem.toString()
        diary.foodName=spinnerFood.selectedItem.toString()
        diary.dogReaction=reactionVar
        diary.description=edit_text_description.text.toString()
        success = dbHendler!!.addDiary(diary)
        if (success) {
            Toast.makeText(this, "Dodano wpis", Toast.LENGTH_LONG).show()
        }

        })


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

}
