package com.example.oogartsapp.ui.homeScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.oogartsapp.Application
import com.example.oogartsapp.data.ArticlesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class HomeScreenViewModel(
    private val articlesRepository: ArticlesRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenState(articles = emptyList()))
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    var homeApiState: HomeApiState by mutableStateOf(HomeApiState.Loading)
        private set

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            try {
                homeApiState = HomeApiState.Loading
                val listResult = articlesRepository.getArticles()
                Log.i("HomeScreenViewModel", listResult.toString())
                _uiState.update {
                    it.copy(articles = listResult)
                }
                homeApiState = HomeApiState.Success(listResult)
            } catch (e: IOException) {
                homeApiState = HomeApiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as Application
                val articlesRepository = application.container.articlesRepository
                HomeScreenViewModel(articlesRepository)
            }
        }
    }
}
