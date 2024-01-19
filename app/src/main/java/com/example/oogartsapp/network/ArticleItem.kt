package com.example.oogartsapp.network

import kotlinx.serialization.Serializable

@Serializable
data class ArticleItem(
    val articles: List<ApiArticle>,
    val totalAmount: Int)

