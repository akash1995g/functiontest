package com.example.myapplication.model

data class User(
    val userName: String = "Image",
    val age: Int = 25,
    var url: String = "https://source.unsplash.com/user/c_v_r/1900x800",
    var date: Long = System.currentTimeMillis()
)
