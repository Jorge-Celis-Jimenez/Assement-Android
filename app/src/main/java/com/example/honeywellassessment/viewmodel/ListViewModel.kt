package com.example.honeywellassessment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.honeywellassessment.R
import com.example.honeywellassessment.model.Item

class ListViewModel : ViewModel() {

    var items = MutableLiveData<ArrayList<Item>>(arrayListOf())
    fun getDummyData() : ArrayList<Item>{
        val data = ArrayList<Item>()
        for (i in 1..5) {
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

    //fun getItems(): ArrayList<Item> {return items.value}

    fun addItem(){
        items.value?.add((Item(R.drawable.ic_launcher_background, "name test", "color test")))
        items.postValue(items.value)
    }
}