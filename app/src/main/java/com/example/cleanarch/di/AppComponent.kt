package com.example.cleanarch.di

import com.example.cleanarch.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class,DataModule::class,DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}