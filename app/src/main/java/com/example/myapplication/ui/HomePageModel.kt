package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomePageModel : ViewModel() {

    private val _list = MutableLiveData<Boolean>()
        init {
            _list.value = false
        }

    val getValue : LiveData<Boolean> = _list

}