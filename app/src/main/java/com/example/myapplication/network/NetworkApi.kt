package com.example.myapplication.network

import okhttp3.ResponseBody
import retrofit2.Callback
import retrofit2.http.POST

interface NetworkApi {

    @POST()
    fun getRandomDog(): Callback<ResponseBody>
}