package com.example.oogartsapp.data

import com.example.oogartsapp.network.TeamApiService
import com.example.oogartsapp.network.ApiTeam

interface TeamRepository {
    suspend fun getTeam(): List<ApiTeam>
}

class ApiTeamRepository(
    private val teamApiService: TeamApiService
): TeamRepository {
    override suspend fun getTeam(): List<ApiTeam> {
        return teamApiService.getTeam().team
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