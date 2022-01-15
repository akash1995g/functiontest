package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import kotlinx.coroutines.*
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

private const val TAG = "HomePage"

class HomePage : AppCompatActivity() {

    var viewProvider: HomePageModel? = null

    val scope = CoroutineScope(Dispatchers.Main)
    val lock = ReentrantLock()
    var int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
            //testCoroutine()
        }

    }

    private fun testCoroutine() {

        System.out.println("Started Coroutine")
        scope.launch(Dispatchers.IO) {
            log(Thread.currentThread().name)
            val job =async {
                log(Thread.currentThread().name)
                delay(2000)
                log("log 1")
            }

            val job1 = async {
                log(Thread.currentThread().name)
                delay(10000)
                log("log 2")
                "test"
            }

            val defered = async {
                log(Thread.currentThread().name)
                delay(2010)
                log("Async")
                "Async"
            }
            val defered1 = async {
                log(Thread.currentThread().name)
                delay(2010)
                log("Async")
                "Async"
            }

            val list = listOf(defered,defered1,job,job1)

           val result = list.awaitAll()
            log("start")

            for (string in result){
                log(string.toString())
            }

        }

        System.out.println("End of Coroutine")

    }


    private fun log(message: String) {
        Log.d(TAG, "log: $message")
    }

}