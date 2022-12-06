package com.codetron.animeku.di

import com.codetron.animeku.data.resources.IRemoteDataSources
import com.codetron.animeku.data.resources.RemoteDataSources
import org.koin.dsl.module

object DataSourcesModule {
    fun getModules() = listOf(sourcesRemoteModule)

    private val sourcesRemoteModule = module {
        single<IRemoteDataSources> { RemoteDataSources(get()) }
    }
}