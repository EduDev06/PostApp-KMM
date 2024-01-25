package util

import di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }.koin
}