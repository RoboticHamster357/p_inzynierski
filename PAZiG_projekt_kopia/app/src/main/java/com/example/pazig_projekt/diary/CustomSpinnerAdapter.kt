package com.example.pazig_projekt.diary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.custom_spinner.view.*

class CustomSpinnerAdapter(ctx: Context,
                           moods: List<Reaction>) :
    ArrayAdapter<Reaction>(ctx, 0, moods) {
    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }
    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }
    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val mood = getItem(position)
        val view = recycledView ?:LayoutInflater.from(context).inflate(
            R.layout.custom_spinner,
            parent,
            false
        )
        view.reactionImage.setImageResource(mood.image)
        view.reactionText.text = mood.description
        return view
    }
}

