package com.example.oogartsapp.network

import com.example.oogartsapp.model.Article
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ArticleApiService {
    @GET("Article")
    suspend fun getArticles(): ArticleItem

    @POST("Article")
    suspend fun createArticle(@Body article: Article?): Call<Void?>
}
