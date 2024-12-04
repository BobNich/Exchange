package com.exchange.feature.signup.data

import com.exchange.feature.signup.domain.SignupActionState
import com.exchange.feature.signup.domain.SignupRepository
import com.exchange.feature.signup.domain.SignupUseCase
import com.exchange.feature.signup.domain.UserSignupForm
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


internal class SignupUseCaseImpl @Inject constructor(
    private val repository: SignupRepository
) : SignupUseCase {
    override suspend fun invoke(form: UserSignupForm) = flow {
        emit(SignupActionState.Progress)
        repository.register(form)
        emit(SignupActionState.Success)
    }.catch { error ->
        val message = error.message ?: error.toString()
        emit(SignupActionState.Failure(message))
    }
}
