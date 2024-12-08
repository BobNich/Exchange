package com.exchange.di

import com.exchange.core.ui.DispatchersList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Singleton
    internal fun providesDispatchers(
    ): DispatchersList {
        return DispatchersList.Base()
    }

}