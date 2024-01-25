package data.network

import kotlinx.coroutines.withContext
import util.Dispatcher

class NetworkDataSource(
    private val api: PostService,
    private val dispatcher: Dispatcher
) {
    suspend fun getPosts() = withContext(dispatcher.ioDispatcher) {
        api.getPosts()
    }
}