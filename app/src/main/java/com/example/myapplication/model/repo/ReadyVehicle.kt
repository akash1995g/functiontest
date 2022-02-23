package com.example.myapplication.model.repo

import com.example.myapplication.model.custominterface.EngineInterface
import com.example.myapplication.model.custominterface.TyreInterface
import javax.inject.Inject

class ReadyVehicle @Inject constructor(private val bus : EngineInterface, private val tyre: TyreInterface) {

    fun getBus(){
        bus.engine("Bus")
        tyre.tyre("MRF")
    }
}