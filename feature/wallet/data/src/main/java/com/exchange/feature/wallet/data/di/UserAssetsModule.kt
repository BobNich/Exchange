package com.exchange.feature.wallet.data.di

import com.exchange.cloud.service.user.ProfileCloudDataSource
import com.exchange.feature.wallet.data.GetUserAssetsUseCaseImpl
import com.exchange.feature.wallet.data.UserAssetsRepositoryImpl
import com.exchange.feature.wallet.domain.GetUserAssetsUseCase
import com.exchange.feature.wallet.domain.UserAssetsRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object UserAssetsModule {

    @Provides
    @Singleton
    internal fun provideUserAssetsRepository(
        cloudDataSource: ProfileCloudDataSource
    ): UserAssetsRepository {
        return UserAssetsRepositoryImpl(
            cloudDataSource = cloudDataSource
        )
    }

    @Provides
    @Singleton
    internal fun provideGetUserAssetsUseCase(
        repository: UserAssetsRepository
    ): GetUserAssetsUseCase {
        return GetUserAssetsUseCaseImpl(repository)
    }

}
