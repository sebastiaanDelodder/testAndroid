package com.example.oogartsapp.data

import com.example.oogartsapp.model.Article
import com.example.oogartsapp.network.ArticleApiService
import com.example.oogartsapp.network.asDomainObjects

interface ArticlesRepository {
    suspend fun getArticles(): List<Article>
}

class ApiArticlesRepository(
    private val userApiService: ArticleApiService,
) : ArticlesRepository {
    override suspend fun getArticles(): List<Article> {
        return userApiService.getArticles().articles.asDomainObjects()
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
