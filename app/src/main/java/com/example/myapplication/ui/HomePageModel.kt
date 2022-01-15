package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.`interface`.NetworkInterface
import com.example.myapplication.repository.Repo

class HomePageModel : ViewModel() {

    private val _list = MutableLiveData<String>()
        init {
            Repo.getImage(object: NetworkInterface{
                override fun feedBack(url: String) {
                    _list.postValue(url)
                }

            })
        }



    val getValue : LiveData<String> = _list

    fun updateImage(){
        Repo.getImage(object: NetworkInterface{
            override fun feedBack(url: String) {
                _list.postValue(url)
            }

        })
    }

}