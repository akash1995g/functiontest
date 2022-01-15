package com.example.myapplication.utils

import android.util.Log

private const val TAG = "Utils"
class Utils {

    companion object{
        const val baseUrl = "https://dog.ceo/api/"
        const val baseUrl1 = "https://dog.ceo/api/breeds/image/random/"

        fun log(message: String?) {
            Log.d(TAG, "log: $message")
        }

    }

}