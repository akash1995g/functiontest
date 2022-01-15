package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

private const val TAG = "HomePage"
class HomePage : AppCompatActivity() {

    var viewProvider: HomePageModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.homepage)

        viewProvider = ViewModelProvider(this).get(HomePageModel::class.java)

        viewProvider?.getValue?.observe(this, Observer {
            it?.let{
                Log.d(TAG, "onCreate: $it")
            }
        })




    }

}