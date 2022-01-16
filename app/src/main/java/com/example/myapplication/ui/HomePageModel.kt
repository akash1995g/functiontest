package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.`interface`.NetworkInterface
import com.example.myapplication.dao.ApiResult
import com.example.myapplication.repository.Repo
import com.example.myapplication.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HomePageModel : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Main)

    private val _list = MutableLiveData<ApiResult>()
        init {
            viewModelScope.launch(Dispatchers.IO) {
                _list.postValue(Repo.getImage())
                Utils.log(Thread.currentThread().name)
            }
        }

    val getValue : LiveData<ApiResult> = _list

    fun updateImage(){
        viewModelScope.launch(Dispatchers.IO) {
            _list.postValue(Repo.getImage())
            Utils.log(Thread.currentThread().name)
        }
    }

}