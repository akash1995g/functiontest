package com.example.myapplication.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Image {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, profileImage: String?) {
            if (profileImage != null) {
                Glide.with(view.context)
                    .load(profileImage)
                    .into(view)
            }
        }
    }

}