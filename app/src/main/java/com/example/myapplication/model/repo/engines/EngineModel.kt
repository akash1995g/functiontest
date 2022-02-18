package com.example.myapplication.model.repo.engines

import javax.inject.Inject

data class EngineModel @Inject constructor(val engine: String, val gearCount: Int)