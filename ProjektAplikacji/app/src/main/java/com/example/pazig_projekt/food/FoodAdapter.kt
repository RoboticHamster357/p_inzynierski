package com.example.pazig_projekt.food

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.dogs_list_item.view.*

class FoodAdapter(private val kofood : ArrayList<FoodList.FoodName>,
                  val context : Context)
    : RecyclerView.Adapter<FoodViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FoodViewHolder {
        return FoodViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.dogs_list_item,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return kofood.size
    }

    override fun onBindViewHolder(p0: FoodViewHolder, p1: Int) {
        val food = kofood.get(p1)
        p0.nameViewButton.text = food.name
        p0.nameViewButton.setOnClickListener{


            val intent = Intent(context, ThisFoodActivity::class.java)
            intent.putExtra("id", food.id)
            context.startActivity(intent)}
    }

}

