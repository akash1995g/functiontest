package com.example.myapplication.model.repo.vehicle

import android.util.Log
import com.example.myapplication.model.repo.engines.EngineModel
import com.example.myapplication.model.repo.tyres.Tyres
import javax.inject.Inject

const val TAG = "Car"

class Car @Inject constructor(private val engineModel: EngineModel, private val tyre: Tyres) {


    fun getVehicleDetails() {
        Log.d(TAG, "getVehicleDetails: $engineModel $tyre")
    }
}