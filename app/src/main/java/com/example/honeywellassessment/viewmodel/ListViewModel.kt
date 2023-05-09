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

    fun addItem(name: String, color: String){
        items.value?.add((Item(R.drawable.ic_launcher_background, name, color)))
        items.postValue(items.value)
    }

    fun setItem(item: Item?){
        items.value?.add(
            (Item(
                item?.image?: R.drawable.ic_launcher_background,
                item?.name ?: "",
                item?.color ?: ""
            ))
        )
        items.postValue(items.value)
    }
}