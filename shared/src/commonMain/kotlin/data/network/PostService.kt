package data.network

import io.ktor.client.call.body
import io.ktor.client.request.get

class PostService: KtorApi() {

    suspend fun getPosts(): List<NetworkPost> = client.get {
        pathUrl("posts")
    }.body()
}