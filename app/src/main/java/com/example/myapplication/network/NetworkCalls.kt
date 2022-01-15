package com.example.myapplication.network

import com.example.myapplication.utils.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkCalls {

    companion object {

        private fun getNetworkInstance(): Retrofit? {
            return Retrofit.Builder()
                .baseUrl(Utils.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        fun getAPIService(): NetworkApi? {
            return getNetworkInstance()?.create(NetworkApi::class.java)
        }

    }

}