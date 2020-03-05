package com.example.pazig_projekt.dog

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.dogs_list_item.view.*

class DogAdapter(private val dogActivity : ArrayList<DogListActivity.DogName>,
                 val context : Context)
    : RecyclerView.Adapter<DogViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DogViewHolder {
        return DogViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.dogs_list_item,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dogActivity.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: DogViewHolder, p1: Int) {
        val dog = dogActivity.get(p1)
        p0.nameViewButton.text = dog.name
        p0.nameViewButton.setOnClickListener{


            val intent = Intent(context, MyDogActivity::class.java)
            intent.putExtra("id", dog.id)
            context.startActivity(intent)}
    }

    }

