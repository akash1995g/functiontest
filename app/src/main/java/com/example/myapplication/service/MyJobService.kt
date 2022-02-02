package com.example.myapplication.service

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

private const val TAG = "MyJobService"

class MyJobService : JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d(TAG, "onStartJob: ")
        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d(TAG, "onStopJob: ")
        return true
    }
}