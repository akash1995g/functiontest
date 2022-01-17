package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.dao.ApiResult
import com.example.myapplication.databinding.HomepageBinding
import com.example.myapplication.network.NetworkCalls
import com.example.myapplication.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.locks.ReentrantLock
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private const val TAG = "HomePage"

class HomePage : AppCompatActivity() {

    var viewProvider: HomePageModel? = null

    private val scope = CoroutineScope(Dispatchers.Main)
    val lock = ReentrantLock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil
            .setContentView<HomepageBinding>(this, R.layout.homepage)

        viewProvider = ViewModelProvider(this)
            .get(HomePageModel::class.java)

        viewProvider?.getValue?.observe(this, Observer {
            it?.let {

                Log.d(TAG, "onCreate: $it")
                binding.apiResult = it

            }
        })

        binding.btn.setOnClickListener {

            viewProvider?.updateImage()

        }

        scope.launch(Dispatchers.IO) {
            log("Started")
            log(testFunction().toString())

        }

    }

    private suspend fun testFunction(): ApiResult? {

        var result: ApiResult? = ApiResult("Error", "Error with Url")

        val callback = NetworkCalls.getAPIService()?.getRandomDog()

        return suspendCoroutine { continuation->
            callback?.enqueue(object : retrofit2.Callback<ApiResult> {
                override fun onResponse(
                    call: Call<ApiResult>?,
                    response: Response<ApiResult>?
                ) {
                    response?.let {

                        if (response.isSuccessful) {
                            result = response.body()
                        }
                    }
                    continuation.resume(result)
                }

                override fun onFailure(call: Call<ApiResult>?, t: Throwable?) {
                    Utils.log(t?.message)
                    continuation.resume(result)
                }

            })
        }
    }

    private fun log(message: String?) {
        Log.d(TAG, "log: $message")
    }

}