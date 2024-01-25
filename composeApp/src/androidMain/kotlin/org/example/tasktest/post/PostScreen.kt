package org.example.tasktest.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import domain.model.Post
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: PostViewModel = koinViewModel()
    val state = viewModel.uiState.collectAsState()

    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(MaterialTheme.colors.primary)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.value.posts) { post ->
                PostItem(
                    color = viewModel.randomBackgroundColor(),
                    post = post
                )
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun PostItem(
    color: String,
    post: Post,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        backgroundColor = Color(color.toColorInt())
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.h6
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = post.body,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}