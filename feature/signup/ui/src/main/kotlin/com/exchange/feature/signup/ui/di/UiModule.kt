package com.exchange.feature.signup.ui.di

import com.exchange.core.ui.StateFlowWrapper
import com.exchange.feature.signup.domain.SignupActionState
import com.exchange.feature.signup.domain.SignupUseCase
import com.exchange.feature.signup.ui.SignupUiState
import com.exchange.feature.signup.ui.interactor.password.PasswordObservable
import com.exchange.feature.signup.ui.interactor.password.PasswordUiState
import com.exchange.feature.signup.ui.interactor.password.UpdatePasswordInteractor
import com.exchange.feature.signup.ui.interactor.signup.SignupInteractor
import com.exchange.feature.signup.ui.interactor.signup.SignupStateMapper
import com.exchange.feature.signup.ui.interactor.signup.SignupStateObservable
import com.exchange.feature.signup.ui.interactor.username.UpdateUsernameInteractor
import com.exchange.feature.signup.ui.interactor.username.UsernameObservable
import com.exchange.feature.signup.ui.interactor.username.UsernameUiState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object UiModule {

    @Provides
    @Singleton
    internal fun providesSignupInteractor(
        useCase: SignupUseCase,
        uiMapper: SignupActionState.Mapper<SignupUiState>,
        observable: StateFlowWrapper.Mutable<SignupUiState>
    ): SignupInteractor<SignupUiState> {
        return SignupInteractor.Base(
            useCase = useCase,
            uiMapper = uiMapper,
            observable = observable
        )
    }

    @Provides
    @Singleton
    internal fun providesSignupStateMapper(
    ): SignupActionState.Mapper<SignupUiState> {
        return SignupStateMapper()
    }

    @Provides
    @Singleton
    internal fun providesSignupObservable(
    ): StateFlowWrapper.Mutable<SignupUiState> {
        return SignupStateObservable()
    }

    @Provides
    @Singleton
    internal fun providesUpdateUsernameInteractor(
        observable: StateFlowWrapper.Mutable<UsernameUiState>
    ): UpdateUsernameInteractor<UsernameUiState> {
        return UpdateUsernameInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @Singleton
    internal fun providesUsernameObservable(
    ): StateFlowWrapper.Mutable<UsernameUiState> {
        return UsernameObservable()
    }

    @Provides
    @Singleton
    internal fun providesUpdatePasswordInteractor(
        observable: StateFlowWrapper.Mutable<PasswordUiState>
    ): UpdatePasswordInteractor<PasswordUiState> {
        return UpdatePasswordInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @Singleton
    internal fun providesPasswordObservable(
    ): StateFlowWrapper.Mutable<PasswordUiState> {
        return PasswordObservable()
    }
}
