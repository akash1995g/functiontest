package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.network.NetworkCalls
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
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

        viewProvider?.getValue?.observe(this, Observer {
            it?.let {
                Log.d(TAG, "onCreate: $it")
            }
        })

        val btn: Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            testCoroutine()
        }


    }

    private fun testCoroutine() {
        log("Clicked")
        scope.launch(Dispatchers.IO) {

            val callback = NetworkCalls.getAPIService()?.getRandomDog()

            callback?.enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>?,
                    response: Response<ResponseBody>?
                ) {
                    log(response?.code().toString())
                }

                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    log(t?.message)
                }

            })

        }

    }


    private fun log(message: String?) {
        Log.d(TAG, "log: $message")
    }

}