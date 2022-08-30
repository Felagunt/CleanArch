package com.example.domain.usecase

import com.example.domain.models.SaveParam
import com.example.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveParam): Boolean {
        return userRepository.saveName(saveParam = param)
    }
}