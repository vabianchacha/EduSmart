package com.vabian.edusmart.repository

import com.vabian.edusmart.data.UserDao
import com.vabian.edusmart.model.User


class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}
class UserRespository {
}