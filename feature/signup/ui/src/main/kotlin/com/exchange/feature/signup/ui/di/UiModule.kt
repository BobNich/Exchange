package com.exchange.feature.signup.ui.di

import com.exchange.core.ui.Flowable
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
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
internal object UiModule {

    @Provides
    @ViewModelScoped
    internal fun providesSignupInteractor(
        useCase: SignupUseCase,
        uiMapper: SignupActionState.Mapper<SignupUiState>,
        observable: Flowable.Mutable<SignupUiState>
    ): SignupInteractor<SignupUiState> {
        return SignupInteractor.Base(
            useCase = useCase,
            uiMapper = uiMapper,
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesSignupStateMapper(
    ): SignupActionState.Mapper<SignupUiState> {
        return SignupStateMapper()
    }

    @Provides
    @ViewModelScoped
    internal fun providesSignupObservable(
    ): Flowable.Mutable<SignupUiState> {
        return SignupStateObservable()
    }

    @Provides
    @ViewModelScoped
    internal fun providesUpdateUsernameInteractor(
        observable: Flowable.Mutable<UsernameUiState>
    ): UpdateUsernameInteractor<UsernameUiState> {
        return UpdateUsernameInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesUsernameObservable(
    ): Flowable.Mutable<UsernameUiState> {
        return UsernameObservable()
    }

    @Provides
    @ViewModelScoped
    internal fun providesUpdatePasswordInteractor(
        observable: Flowable.Mutable<PasswordUiState>
    ): UpdatePasswordInteractor<PasswordUiState> {
        return UpdatePasswordInteractor.Base(
            observable = observable
        )
    }

    @Provides
    @ViewModelScoped
    internal fun providesPasswordObservable(
    ): Flowable.Mutable<PasswordUiState> {
        return PasswordObservable()
    }
}
