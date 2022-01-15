package com.example.myapplication.network

import com.example.myapplication.dao.ApiResult
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {

    @GET("breeds/image/random/")
    fun getRandomDog(): Call<ApiResult>
}