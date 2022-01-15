package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.dao.ApiResult
import com.example.myapplication.databinding.HomepageBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.locks.ReentrantLock

private const val TAG = "HomePage"

class HomePage : AppCompatActivity() {

    var viewProvider: HomePageModel? = null

    val scope = CoroutineScope(Dispatchers.Main)
    val lock = ReentrantLock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil
            .setContentView<HomepageBinding>(this, R.layout.homepage)

        viewProvider = ViewModelProvider(this)
            .get(HomePageModel::class.java)

        viewProvider?.getValue?.observe(this, Observer {
            it?.let {

                Log.d(TAG, "onCreate: ${it}")
                binding.apiResult = it
               // Glide.with(this).load(it).into(binding.image)

            }
        })

        binding.btn.setOnClickListener {

            viewProvider?.updateImage()

        }

    }

    private fun log(message: String?) {
        Log.d(TAG, "log: $message")
    }

}