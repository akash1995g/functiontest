package com.example.myapplication.di

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * we can use @Named("") to the dagger to match variable from with other variable
 * we build a custom annotation
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class EngineScope


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class TyreScope
