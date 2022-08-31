package com.example.cleanarch.app

import android.app.Application
import com.example.cleanarch.di.AppComponent
import com.example.cleanarch.di.AppModule
import com.example.cleanarch.di.DaggerAppComponent

class App : Application() {

    lateinit var appCompanent: AppComponent


    override fun onCreate() {
        super.onCreate()

        appCompanent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}