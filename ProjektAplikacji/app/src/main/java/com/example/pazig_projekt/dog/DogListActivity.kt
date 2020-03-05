package com.example.pazig_projekt.dog


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import com.example.pazig_projekt.R
import com.example.pazig_projekt.database.DatabaseHandler
import kotlinx.android.synthetic.main.activity_dogs_list.*

class DogListActivity : AppCompatActivity() {

    var dbHendler: DatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dogs_list)

        var dogs = getDogsFromDatabase()


        rv_dogs_list.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter(dogs, this)
        rv_dogs_list.adapter = adapter

        val actionButton = findViewById<FloatingActionButton>(R.id.buttonNewDog)

        actionButton.setOnClickListener {
            val intent = Intent(this, NewDogActivity::class.java)
            startActivity(intent)
        }


    }

    private fun getDogsFromDatabase(): ArrayList<DogName> {
        dbHendler = DatabaseHandler(this)
        var dogs = dbHendler!!.getDogNames()
        return dogs
    }

    class DogName(val id: String, val name: String)
}


