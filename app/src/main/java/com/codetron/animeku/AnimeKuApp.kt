package com.codetron.animeku

import android.app.Application
import com.codetron.animeku.di.DataSourcesModule
import com.codetron.animeku.di.RepositoryModule
import com.codetron.animeku.di.ServiceModule
import com.codetron.animeku.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AnimeKuApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AnimeKuApp)
            modules(
                ServiceModule.getModules() +
                        DataSourcesModule.getModules() +
                        RepositoryModule.getModules() +
                        ViewModelModule.getModules()
            )
        }
    }

}