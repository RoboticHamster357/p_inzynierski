package com.example.pazig_projekt.products

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.products_item.view.*

class ProductsAdapter(private val products : ArrayList<Product>,
                      val context : Context)
    : RecyclerView.Adapter<ProductsViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductsViewHolder {
        return ProductsViewHolder(
            LayoutInflater.from(p0.context).inflate(
                R.layout.products_item,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(p0: ProductsViewHolder, p1: Int) {
        val product = products.get(p1)
        p0.productName.text = product.productName
        p0.productDescription.text = product.productDescription
        p0.productRecommendation.setImageResource(product.productRecommendation)
    }


}

