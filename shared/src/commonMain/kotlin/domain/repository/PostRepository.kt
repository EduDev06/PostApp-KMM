package domain.repository

import domain.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}