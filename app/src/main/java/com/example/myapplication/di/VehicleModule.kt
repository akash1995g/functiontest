package com.example.myapplication.di

import com.example.myapplication.model.custominterface.EngineInterface
import com.example.myapplication.model.custominterface.TyreInterface
import com.example.myapplication.model.repo.engines.EngineModel
import com.example.myapplication.model.repo.tyres.Tyres
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class VehicleModule {


    @Provides
    fun getEngineClass(@EngineScope engineModel: String, @EngineScope count: Int): EngineModel {
        return EngineModel(engineModel, count)
    }


    @Provides
    fun getTyreClass( @TyreScope tyreBrand: String, @TyreScope count: Int): Tyres {
        return Tyres(tyreBrand, count)
    }

    @Binds
    abstract fun getEngine() : EngineInterface

    @Binds
    abstract fun getTyre() : TyreInterface


}