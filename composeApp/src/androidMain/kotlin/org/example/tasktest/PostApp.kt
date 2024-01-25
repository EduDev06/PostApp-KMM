package org.example.tasktest

import android.app.Application
import di.getSharedModules
import org.example.tasktest.di.appModule
import org.koin.core.context.startKoin

class PostApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}