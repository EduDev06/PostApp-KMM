package util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class IosDispatcher: Dispatcher {
    override val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}

actual fun provideDispatcher(): Dispatcher = IosDispatcher()