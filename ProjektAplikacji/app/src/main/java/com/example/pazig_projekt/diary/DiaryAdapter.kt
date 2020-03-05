package com.example.pazig_projekt.diary

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.diary_item.view.*

class DiaryAdapter(private val diaryActivity : ArrayList<DiaryActivity.DiaryInformation>,
                 val context : Context)
    : RecyclerView.Adapter<DiaryViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiaryViewHolder {
        return DiaryViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.diary_item,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return diaryActivity.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: DiaryViewHolder, p1: Int) {
        val diary = diaryActivity.get(p1)

        val date = diary.day.toString() + "/" + diary.month + "/" + diary.yaer
        p0.tv_diary_date.text = date
        p0.tv_diary_dog.text=diary.dogName
        p0.tv_diary_food.text=diary.foodName
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


