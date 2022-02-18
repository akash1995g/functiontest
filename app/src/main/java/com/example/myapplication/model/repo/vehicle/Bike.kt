package com.example.myapplication.model.repo.vehicle

import android.util.Log
import com.example.myapplication.model.custominterface.EngineInterface
import com.example.myapplication.model.custominterface.TyreInterface
import javax.inject.Inject

class Bike @Inject constructor() : EngineInterface, TyreInterface {
    override fun engine(model: String) {
        Log.d(TAG, "engine: model : $model")
    }

    override fun tyre(tyre: String) {
        Log.d(TAG, "tyre: $tyre")
    }

}