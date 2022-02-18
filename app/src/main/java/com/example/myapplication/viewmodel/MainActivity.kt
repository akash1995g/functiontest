package com.example.myapplication.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.di.DaggerComponent
import com.example.myapplication.model.repo.vehicle.Bike
import com.example.myapplication.model.repo.vehicle.Car
import javax.inject.Inject

// Refer cheesy code youtube for dagger

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var car: Car

    @Inject
    lateinit var bike:Bike

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val component = DaggerComponent.factory()
            .create("Turbo", 7, "MRF", 2)
        component.inject(this)

        bike.engine("Test ")

        car.getVehicleDetails()

    }
}