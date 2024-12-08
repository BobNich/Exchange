package com.exchange.feature.wallet.data.di

import com.exchange.account.UserAccount
import com.exchange.cloud.service.user.ProfileCloudDataSource
import com.exchange.feature.wallet.data.GetUserWalletUseCaseImpl
import com.exchange.feature.wallet.data.GetUsernameUseCaseImpl
import com.exchange.feature.wallet.data.UserWalletRepositoryImpl
import com.exchange.feature.wallet.domain.GetUserWalletUseCase
import com.exchange.feature.wallet.domain.GetUsernameUseCase
import com.exchange.feature.wallet.domain.UserWalletRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object UserWalletModule {

    @Provides
    @Singleton
    internal fun provideUserAssetsRepository(
        cloudDataSource: ProfileCloudDataSource
    ): UserWalletRepository {
        return UserWalletRepositoryImpl(
            cloudDataSource = cloudDataSource
        )
    }

    @Provides
    @Singleton
    internal fun provideGetUserAssetsUseCase(
        repository: UserWalletRepository
    ): GetUserWalletUseCase {
        return GetUserWalletUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    internal fun provideGetUsernameUseCase(
        userAccount: UserAccount
    ): GetUsernameUseCase {
        return GetUsernameUseCaseImpl(
            userAccount = userAccount
        )
    }

}
