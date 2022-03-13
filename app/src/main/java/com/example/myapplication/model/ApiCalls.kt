package com.example.myapplication.model

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiCalls {
    @GET("/")
    fun indexPage():Call<ResponseBody>
}