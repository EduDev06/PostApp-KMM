package org.example.tasktest.di

import org.example.tasktest.post.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PostViewModel(get(), get()) }
}