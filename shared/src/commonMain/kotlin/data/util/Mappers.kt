package data.util

import data.network.NetworkPost
import domain.model.Post

fun NetworkPost.asExternalModel() = Post(
    id = id,
    userId = userId,
    title = title,
    body = body
)