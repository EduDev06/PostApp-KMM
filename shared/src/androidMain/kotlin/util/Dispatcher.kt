package util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AndroidDispatcher: Dispatcher {
    override val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}

actual fun provideDispatcher(): Dispatcher = AndroidDispatcher()