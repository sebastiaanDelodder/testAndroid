package com.example.oogartsapp.ui.homeScreen

import com.example.oogartsapp.model.Article

data class HomeScreenState(
    val articles: List<Article>
)

sealed interface HomeApiState {
    object Loading : HomeApiState
    object Error : HomeApiState
    data class Success(val articles: List<Article>) : HomeApiState
}