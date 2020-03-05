package com.example.pazig_projekt.dog

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.diary_food_item.view.*

class DiaryDogAdapter(private val diaryActivity : ArrayList<MyDogActivity.SpecificDogDiary>,
                       val context : Context
)
    : RecyclerView.Adapter<DiaryDogViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiaryDogViewHolder {
        return DiaryDogViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.diary_food_item,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return diaryActivity.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: DiaryDogViewHolder, p1: Int) {
        val diary = diaryActivity.get(p1)

        val date = diary.day.toString() + "/" + diary.month + "/" + diary.yaer
        p0.tv_diary_date.text = date
        p0.tv_diary_dog.text=diary.foodName
        p0.tv_diary_description.text=diary.description
        if(diary.dogReaction==1)
        {
            p0.iv_diary_dog_reaction.setImageResource(R.drawable.ic_smiley_24dp)
        }
        else
        {
            p0.iv_diary_dog_reaction.setImageResource(R.drawable.ic_sad_24dp)

        }

    }

}


