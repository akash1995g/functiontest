package com.example.myapplication.dao

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("status")
    val status:String,
    @SerializedName("message")
    val result:String
)
