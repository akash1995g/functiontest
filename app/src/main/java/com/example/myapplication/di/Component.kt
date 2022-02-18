package com.example.myapplication.di

import com.example.myapplication.viewmodel.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [VehicleModule::class])
interface Component {

    @Component.Factory
    interface Factory {
        fun create(
            @EngineScope @BindsInstance engineName: String,
            @EngineScope @BindsInstance gearCount: Int,
            @TyreScope @BindsInstance tyre: String,
            @TyreScope @BindsInstance numberTyre: Int
        ): com.example.myapplication.di.Component

    }

    fun inject(mainActivity: MainActivity)

}