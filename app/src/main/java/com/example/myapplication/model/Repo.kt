package com.example.myapplication.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repo {

    private val baseUrl = "https://192.168.1.39:4442"
    private fun call(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun callIndexPage(okHttpClient: OkHttpClient): ApiCalls {
       return call(okHttpClient).create(ApiCalls::class.java)
    }

}