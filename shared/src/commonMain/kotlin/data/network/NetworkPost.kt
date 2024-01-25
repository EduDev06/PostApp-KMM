package data.network

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPost(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
