package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _listOfShoes =  MutableLiveData<MutableList<Shoe>>()
    val listOfShoes : LiveData<MutableList<Shoe>>
            get() = _listOfShoes

    // this variable is used to close the ShoeDetailFragment when we press the save button
    private val _isSaved = MutableLiveData<Boolean>()
    val isSaved: LiveData<Boolean>
        get() = _isSaved

    init {
        /* // WE CAN USE A DEFAULT VALUE FOR TESTING
        val shoes = mutableListOf(Shoe("STAN SMITH Shoes", 8.5, "Adidas",
            "Timeless appeal. Effortless style. Everyday versatility. For over 50 years and " +
                    "counting, adidas Stan Smith Shoes have continued to hold their place as an icon."))

        _listOfShoes.value = shoes
         */
        _listOfShoes.value = mutableListOf()
        _isSaved.value = false
    }

    fun updateShoeList(newShoe: Shoe){
        _listOfShoes.value?.add(newShoe)
        _isSaved.value = true
    }

    fun onSavedComplete(){
        _isSaved.value = false
    }

    // when the user logOut
    fun resetListOfShoes(){
        _listOfShoes.value = mutableListOf()
    }
}