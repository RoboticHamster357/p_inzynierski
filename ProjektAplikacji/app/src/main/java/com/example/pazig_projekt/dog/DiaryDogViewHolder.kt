package com.example.pazig_projekt.dog

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.diary_food_item.view.*

class DiaryDogViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val tv_diary_date = view.tv_diary_date
    val tv_diary_dog = view.tv_diary_dog
    val tv_diary_description=view.tv_diary_description
    val iv_diary_dog_reaction=view.iv_diary_dog_reaction
}