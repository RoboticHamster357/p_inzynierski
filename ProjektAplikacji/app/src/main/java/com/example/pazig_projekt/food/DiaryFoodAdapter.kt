package com.example.pazig_projekt.food

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pazig_projekt.R
import com.example.pazig_projekt.diary.DiaryActivity
import kotlinx.android.synthetic.main.diary_food_item.view.*

class DiaryFoodAdapter(private val diaryActivity : ArrayList<ThisFoodActivity.SpecificFoodDiary>,
                   val context : Context
)
    : RecyclerView.Adapter<DiaryFoodViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DiaryFoodViewHolder {
        return DiaryFoodViewHolder(
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

    override fun onBindViewHolder(p0: DiaryFoodViewHolder, p1: Int) {
        val diary = diaryActivity.get(p1)

        val date = diary.day.toString() + "/" + diary.month + "/" + diary.yaer
        p0.tv_diary_date.text = date
        p0.tv_diary_dog.text=diary.dogName
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

class DiaryFoodViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val tv_diary_date = view.tv_diary_date
    val tv_diary_dog = view.tv_diary_dog
    val tv_diary_description=view.tv_diary_description
    val iv_diary_dog_reaction=view.iv_diary_dog_reaction
}
