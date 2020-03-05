package com.example.pazig_projekt.food

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.pazig_projekt.R

class NewHomemadeMealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_homemade_meal)

        val products = ArrayList<HommemadeMealProduct>()
        products.add(HommemadeMealProduct("Udko z kuczaka",215.0,"meat"))
        products.add(HommemadeMealProduct("Pierś z kurczaka",164.9,"meat"))

        products.add(HommemadeMealProduct("Marchew",41.3,"vegetable"))
        products.add(HommemadeMealProduct("Dynia",26.1,"vegetable"))

        products.add(HommemadeMealProduct("Ryż",130.0,"extender"))


        val meatArray = arrayOf<String>()
        val vegetablesArray = arrayOf<String>()
        val extenderArray = arrayOf<String>()

        var x=1
        while(x!=products.size)
        {
            if(products[x].category=="meat")
            {
                meatArray+products[x].name
            }
            x++
        }

        val spinnerMeat = findViewById<Spinner>(R.id.spinnerMeat)
        createSpinner(meatArray, spinnerMeat)

        val spinnerVegetables = findViewById<Spinner>(R.id.spinnerVegetables)
        createSpinner(vegetablesArray, spinnerVegetables)

        val spinnerExtender = findViewById<Spinner>(R.id.spinnerExtender)
        createSpinner(extenderArray, spinnerExtender)

    }
    private fun createSpinner(contentArray: Array<String>, spinner: Spinner) {
        if (spinner != null) {
            val arrayAdapterGender = ArrayAdapter(this, android.R.layout.simple_spinner_item, contentArray)
            spinner.adapter = arrayAdapterGender

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }
}
class HommemadeMealProduct(val name:String,val calorific:Double,val category:String)

