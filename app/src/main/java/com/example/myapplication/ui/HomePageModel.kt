package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.`interface`.NetworkInterface
import com.example.myapplication.dao.ApiResult
import com.example.myapplication.repository.Repo

class HomePageModel : ViewModel() {

    private val _list = MutableLiveData<ApiResult>()
        init {
            Repo.getImage(object: NetworkInterface{
                override fun feedBack(url: ApiResult) {
                    _list.postValue(url)
                }

            })
        }



    val getValue : LiveData<ApiResult> = _list

    fun updateImage(){
        Repo.getImage(object: NetworkInterface{
            override fun feedBack(url: ApiResult) {
                _list.postValue(url)
            }

        })
    }

}