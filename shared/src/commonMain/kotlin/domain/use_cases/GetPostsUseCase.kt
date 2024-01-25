package domain.use_cases

import domain.model.Post
import domain.repository.PostRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetPostsUseCase: KoinComponent {
    private val repository: PostRepository by inject()

    suspend operator fun invoke(): List<Post> {
        return repository.getPosts()
    }
}