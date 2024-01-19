package com.example.oogartsapp.data

import com.example.oogartsapp.network.UserApiService
import com.example.oogartsapp.network.ApiUser

interface UsersRepository {
    suspend fun getUsers(): List<ApiUser>
}

class ApiUsersRepository(
    private val userApiService: UserApiService
): UsersRepository {
    override suspend fun getUsers(): List<ApiUser> {
        return userApiService.getUsers().users
    }
}
/*
interface UsersRepository {
    suspend fun getUsers(): List<User>
    suspend fun isValidUser(username: String, password: String): Boolean {
        val users = getUsers()
        return users.any { it.email == username && it.passwordHash == password }
    }
}

class ApiUsersRepository(
    private val userApiService: UserApiService
): UsersRepository{
    override suspend fun getUsers(): List<User> {
        return userApiService.getUsers().asDomainObjects()
    }
}*/