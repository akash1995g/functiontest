package com.example.myapplication.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {

    @GET("breeds/image/random/")
    fun getRandomDog(): Call<ResponseBody>
}