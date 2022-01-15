package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.network.NetworkCalls
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.locks.ReentrantLock

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

        val btn: Button = findViewById(R.id.btn)
        val image: ImageView = findViewById(R.id.image)

        viewProvider?.getValue?.observe(this, Observer {
            it?.let {

                Log.d(TAG, "onCreate: $it")
                Glide.with(this).load(it).into(image)

            }
        })

        btn.setOnClickListener {

            viewProvider?.updateImage()

        }


    }

    private fun log(message: String?) {
        Log.d(TAG, "log: $message")
    }

}