package com.exchange.feature.settings.data.di

import com.exchange.account.UserAccount
import com.exchange.feature.settings.data.LogoutUseCaseImpl
import com.exchange.feature.settings.domain.LogoutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object LogoutModule {

    @Provides
    @Singleton
    internal fun providesLogoutUseCase(
        userAccount: UserAccount
    ): LogoutUseCase {
        return LogoutUseCaseImpl(
            userAccount = userAccount
        )
    }

}
