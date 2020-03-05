package com.example.pazig_projekt.diary

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.diary_item.view.*

class DiaryViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val tv_diary_date = view.tv_diary_date
    val tv_diary_dog = view.tv_diary_dog
    val tv_diary_food=view.tv_diary_food
    val tv_diary_description=view.tv_diary_description
    val iv_diary_dog_reaction=view.iv_diary_dog_reaction
}