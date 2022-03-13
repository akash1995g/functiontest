package com.example.myapplication.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

object CommonFunction {

}

fun ImageView.load(url: String) {

    val circular = CircularProgressDrawable(this.context).apply {
        this.strokeWidth = 10F
        this.centerRadius = 30F
        this.start()
    }

    Glide.with(this)
        .load(url)
        .placeholder(circular)
        .into(this)
}

@BindingAdapter("android:url")
fun loadImage(imageView: ImageView, url: String) {
    imageView.load(url)
}



