package com.exchange.feature.signup.data.di

import com.exchange.cloud.service.register.RegisterCloudDataSource
import com.exchange.feature.signup.data.SignupRepositoryImpl
import com.exchange.feature.signup.data.SignupUseCaseImpl
import com.exchange.feature.signup.domain.SignupRepository
import com.exchange.feature.signup.domain.SignupUseCase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object SignupModule {

    @Provides
    @Singleton
    internal fun provideSignupRepository(
        cloudDataSource: RegisterCloudDataSource
    ): SignupRepository {
        return SignupRepositoryImpl(
            cloudDataSource = cloudDataSource
        )
    }

    @Provides
    @Singleton
    internal fun provideSignupUseCase(
        repository: SignupRepository
    ): SignupUseCase {
        return SignupUseCaseImpl(repository)
    }

}
