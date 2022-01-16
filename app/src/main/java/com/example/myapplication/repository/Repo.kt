package com.example.myapplication.repository

import com.example.myapplication.dao.ApiResult
import com.example.myapplication.network.NetworkCalls
import com.example.myapplication.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Repo {

    companion object {

        suspend fun getImage() : ApiResult?{

            var result: ApiResult? = ApiResult("Error", "Error with Url")

            val callback = NetworkCalls.getAPIService()?.getRandomDog()

            return suspendCoroutine { continuation->
                callback?.enqueue(object : Callback<ApiResult> {
                    override fun onResponse(
                        call: Call<ApiResult>?,
                        response: Response<ApiResult>?
                    ) {
                        response?.let {

                            if (response.isSuccessful) {
                                result = response.body()
                            }
                        }
                        continuation.resume(result)
                    }

                    override fun onFailure(call: Call<ApiResult>?, t: Throwable?) {
                        Utils.log(t?.message)
                        continuation.resume(result)
                    }

                })
            }


        }
    }

}