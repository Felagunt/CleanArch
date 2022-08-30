package com.example.cleanarch.data.repository

import com.example.cleanarch.data.storage.models.User
import com.example.cleanarch.data.storage.UserStorage
//import com.example.cleanarch.domain.models.SaveParam
import com.example.domain.models.SaveParam
import com.example.domain.models.UserName
//import com.example.cleanarch.domain.models.UserName
//import com.example.cleanarch.domain.repository.UserRepository
import com.example.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveParam): Boolean {
        val user = User(firstName = saveParam.name, lastName = "")

        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }


}