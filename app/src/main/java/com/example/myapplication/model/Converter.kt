package com.example.myapplication.model

import androidx.databinding.BindingConversion
import java.text.SimpleDateFormat
import java.util.*


object Converter {
    // companion object {

    @JvmStatic
    @BindingConversion
    fun simpleDataFormat(long: Long): String {
        val date = Date(long)
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(date)
    }
    //}
}

