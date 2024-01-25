package org.example.tasktest.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Post
import domain.use_cases.GetPostsUseCase
import domain.use_cases.RandomBackgroundColorUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsUseCase: GetPostsUseCase,
    private val randomBackgroundColorUseCase: RandomBackgroundColorUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(ProductState())
    val uiState = _uiState.asStateFlow()

    init {
        updatePosts()
    }

    fun randomBackgroundColor(): String {
        return randomBackgroundColorUseCase()
    }

    private fun updatePosts() {
        viewModelScope.launch {
            val posts = getPostsUseCase()
            _uiState.update {
                it.copy(posts = posts)
            }
        }
    }
}

data class ProductState(
    val posts: List<Post> = emptyList()
)