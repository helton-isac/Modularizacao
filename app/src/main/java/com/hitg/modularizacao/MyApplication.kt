package com.hitg.modularizacao

import android.app.Application
import com.hitg.data.di.dataModules
import com.hitg.domain.di.domainModule
import com.hitg.modularizacao.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}