package com.example.cleanarch.di

import android.content.Context
import com.example.cleanarch.data.repository.UserRepositoryImpl
import com.example.cleanarch.data.storage.UserStorage
import com.example.cleanarch.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context):UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage):UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }
}