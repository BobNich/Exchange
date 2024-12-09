package com.exchange.di

import android.content.Context
import com.exchange.core.ui.DispatchersList
import com.exchange.core.ui.Resource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    internal fun providesResource(
        @ApplicationContext context: Context
    ): Resource {
        return Resource.Base(
            context = context
        )
    }

}