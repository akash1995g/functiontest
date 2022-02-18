package com.example.myapplication.di

import com.example.myapplication.model.repo.engines.EngineModel
import com.example.myapplication.model.repo.tyres.Tyres
import dagger.Module
import dagger.Provides

@Module
class VehicleModule {


    @Provides
    fun getEngineClass(@EngineScope engineModel: String, @EngineScope count: Int): EngineModel {
        return EngineModel(engineModel, count)
    }


    @Provides
    fun getTyreClass( @TyreScope tyreBrand: String, @TyreScope count: Int): Tyres {
        return Tyres(tyreBrand, count)
    }

}