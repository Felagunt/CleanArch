package com.example.cleanarch.di

import com.example.cleanarch.data.repository.UserRepositoryImpl
import com.example.cleanarch.data.storage.UserStorage
import com.example.cleanarch.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.domain.repository.UserRepository
import org.koin.core.scope.get
import org.koin.dsl.module



val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }


}