package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.HomepageBinding
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

private const val TAG = "HomePage"

class HomePage : AppCompatActivity() {

    var viewProvider: HomePageModel? = null

    val scope = CoroutineScope(Dispatchers.Main)
    val lock = ReentrantLock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  https://dog.ceo/api/breeds/image/random

        setContentView(R.layout.homepage)

        viewProvider = ViewModelProvider(this).get(HomePageModel::class.java)

        viewProvider?.getValue?.observe(this, Observer {
            it?.let {
                Log.d(TAG, "onCreate: $it")
            }
        })

        val btn: Button = findViewById(R.id.btn)
        btn.text = "Click"

        btn.setOnClickListener {
            testCoroutine()
        }


    }

    private fun testCoroutine() {


    }


    private fun log(message: String) {
        Log.d(TAG, "log: $message")
    }

}