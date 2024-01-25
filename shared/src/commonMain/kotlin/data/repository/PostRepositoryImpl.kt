package data.repository

import data.network.NetworkDataSource
import data.util.asExternalModel
import domain.model.Post
import domain.repository.PostRepository

class PostRepositoryImpl(
    private val networkDataSource: NetworkDataSource
): PostRepository {
    override suspend fun getPosts(): List<Post> {
        return networkDataSource.getPosts().map { it.asExternalModel() }
    }
}