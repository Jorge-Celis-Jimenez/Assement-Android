package com.example.honeywellassessment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.honeywellassessment.R
import com.example.honeywellassessment.model.Item

class ListViewModel : ViewModel() {

    fun getDummyData() : ArrayList<Item>{
        val data = ArrayList<Item>()
        for (i in 1..20) {
            data.add(
                Item(
                    image = R.drawable.ic_launcher_background,
                    name = "Item " + i,
                    color = "black"
                )
            )
        }
        return data
    }
}