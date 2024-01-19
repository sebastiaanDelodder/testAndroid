package com.example.oogartsapp.network

import com.example.oogartsapp.model.Article
import kotlinx.serialization.Serializable

@Serializable
data class ApiArticle(
    val id: Int,
    var title: String,
    var imageUrl: String,
    var description: String
) {
}


fun List<ApiArticle>.asDomainObjects(): List<Article> {
    return this.map {
        Article(
            id = it.id,
            title = it.title,
            imageUrl = it.imageUrl,
            description = it.description
        )
    }
}