package com.exchange.feature.login.data.di

import com.exchange.account.UserAccount
import com.exchange.cloud.service.login.LoginCloudDataSource
import com.exchange.feature.login.data.LoginRepositoryImpl
import com.exchange.feature.login.data.LoginUseCaseImpl
import com.exchange.feature.login.domain.LoginRepository
import com.exchange.feature.login.domain.LoginUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object LoginModule {

    @Provides
    @Singleton
    internal fun provideLoginRepository(
        cloudDataSource: LoginCloudDataSource,
        userAccount: UserAccount
    ): LoginRepository {
        return LoginRepositoryImpl(
            cloudDataSource = cloudDataSource,
            userAccount = userAccount
        )
    }

    @Provides
    @Singleton
    internal fun provideLoginUseCase(
        repository: LoginRepository
    ): LoginUseCase {
        return LoginUseCaseImpl(repository)
    }

}
