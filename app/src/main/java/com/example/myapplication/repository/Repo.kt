package com.example.myapplication.repository

import com.example.myapplication.`interface`.NetworkInterface
import com.example.myapplication.dao.Result
import com.example.myapplication.network.NetworkCalls
import com.example.myapplication.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class Repo {

    companion object {

        private val scope = CoroutineScope(Dispatchers.Main)

        fun getImage(listener: NetworkInterface) {

            scope.launch(Dispatchers.IO) {

                val callback = NetworkCalls.getAPIService()?.getRandomDog()

                callback?.enqueue(object : retrofit2.Callback<Result> {
                    override fun onResponse(
                        call: Call<Result>?,
                        response: Response<Result>?
                    ) {
                        response?.let {

                            if (response.isSuccessful) {
                                val result = response.body()
                                result?.let {
                                    listener.feedBack(it.result)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<Result>?, t: Throwable?) {
                        Utils.log(t?.message)
                    }

                })

            }
        }
    }

}