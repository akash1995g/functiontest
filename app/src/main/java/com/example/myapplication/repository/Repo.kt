package com.example.myapplication.repository

import com.example.myapplication.`interface`.NetworkInterface
import com.example.myapplication.dao.ApiResult
import com.example.myapplication.network.NetworkCalls
import com.example.myapplication.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class Repo {

    companion object {

        private val scope = CoroutineScope(Dispatchers.Main)

        fun getImage(listener: NetworkInterface) {

            scope.launch(Dispatchers.IO) {

                val callback = NetworkCalls.getAPIService()?.getRandomDog()

                callback?.enqueue(object : retrofit2.Callback<ApiResult> {
                    override fun onResponse(
                        call: Call<ApiResult>?,
                        response: Response<ApiResult>?
                    ) {
                        response?.let {

                            if (response.isSuccessful) {
                                val result = response.body()
                                result?.let {
                                    listener.feedBack(it)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<ApiResult>?, t: Throwable?) {
                        Utils.log(t?.message)
                    }

                })

            }
        }
    }

}