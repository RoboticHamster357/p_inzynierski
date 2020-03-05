package com.example.pazig_projekt.products

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.products_item.view.*

class ProductsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val productName = view.tvProductName
    val productRecommendation = view.ivProductRecommendation
    val productDescription = view.tvProductDescription}