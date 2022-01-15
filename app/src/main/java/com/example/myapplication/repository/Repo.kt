package com.example.myapplication.repository

import com.example.myapplication.`interface`.NetworkInterface
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

                callback?.enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>?,
                        response: Response<ResponseBody>?
                    ) {
                        response?.let {

                            if (response.isSuccessful) {
                                val result = response.body().string()
                                val json = JSONObject(result)
                                val url = json.getString("message")
                                Utils.log(url)
                                listener.feedBack(url)
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                        Utils.log(t?.message)
                    }

                })

            }
        }
    }

}