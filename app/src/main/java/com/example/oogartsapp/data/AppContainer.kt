package com.example.oogartsapp.data

import com.example.oogartsapp.model.Article
import com.example.oogartsapp.network.ApiTeam
import com.example.oogartsapp.network.ArticleApiService
import com.example.oogartsapp.network.TeamApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

interface AppContainer {
    // val usersRepository: UsersRepository
    val articlesRepository: ArticlesRepository
    val teamRepository: TeamRepository
}

class DefaultAppContainer() : AppContainer {

    private val baseUrl = "https://devops-g5.lamdev.be/api/"
    // private val baseUrl = "https://10.0.2.2:5001/api/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType()),
        )
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    /*
    private val retrofitUserService : UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }*/

    /*
    override val usersRepository: UsersRepository by lazy {
        ApiUsersRepository(retrofitUserService)
    }*/

    private val retrofitArticleService: ArticleApiService by lazy {
        retrofit.create(ArticleApiService::class.java)
    }

    override val articlesRepository: ArticlesRepository by lazy {
        ApiArticlesRepository(retrofitArticleService)
    }

    private val retrofitTeamService: TeamApiService by lazy {
        retrofit.create(TeamApiService::class.java)
    }

    override val teamRepository: TeamRepository by lazy {
        ApiTeamRepository(retrofitTeamService)
    }

    /*
    suspend fun doesUsernameExist(username: String): Boolean {
        val users = usersRepository.getUsers()
        return users.any { it.email == username }
    }*/

    suspend fun getArticle(): List<Article> {
        val articles = articlesRepository.getArticles()
        return articles
    }

    suspend fun getTeam(): List<ApiTeam> {
        val team = teamRepository.getTeam()
        return team
    }
}
