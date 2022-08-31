package com.example.cleanarch.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetUserNameUseCase
import com.example.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(
    val getUserNameUseCase: GetUserNameUseCase,
    val saveUserNameUseCase: SaveUserNameUseCase
): ViewModelProvider.Factory {




    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase= getUserNameUseCase,
            saveUserNameUseCase= saveUserNameUseCase
        ) as T
    }
}