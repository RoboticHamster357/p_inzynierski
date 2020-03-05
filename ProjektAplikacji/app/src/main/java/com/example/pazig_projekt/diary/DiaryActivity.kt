package com.example.pazig_projekt.diary

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_dogs_list.*

class DiaryActivity : AppCompatActivity() {
    var dbHendler: DatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs_list)

        var diary = getDiaryFromDatabase()
        rv_dogs_list.layoutManager = LinearLayoutManager(this)

        val adapter = DiaryAdapter(diary, this)
        rv_dogs_list.adapter = adapter


        val actionButton = findViewById<FloatingActionButton>(R.id.buttonNewDog)

        actionButton.setOnClickListener {
            val intent = Intent(this, AddToDiaryActivity::class.java)
            startActivity(intent)
        }
        tv_title.text="DZIENNICZEK"


    }
    private fun getDiaryFromDatabase(): ArrayList<DiaryInformation> {
        dbHendler = DatabaseHandler(this)
        var diary = dbHendler!!.getAllDiary()
        return diary
    }


class DiaryInformation (val diaryID : String,val yaer:Int,val month:Int,val day:Int,val dogId:Int, val foodId:Int,val dogReaction:Int,val description:String,val dogName:String,val foodName:String)
}
