package util

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    val ioDispatcher: CoroutineDispatcher
}

expect fun provideDispatcher(): Dispatcher