package com.exchange.feature.login.data

import com.exchange.feature.login.domain.LoginActionState
import com.exchange.feature.login.domain.LoginRepository
import com.exchange.feature.login.domain.LoginUseCase
import com.exchange.feature.login.domain.UserLoginForm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


internal class LoginUseCaseImpl @Inject constructor(
    private val repository: LoginRepository
) : LoginUseCase {
    override fun invoke(form: UserLoginForm): Flow<LoginActionState> = flow {
        emit(LoginActionState.Progress)
        repository.authenticate(form)
        emit(LoginActionState.Success)
    }.catch { error ->
        error.printStackTrace()
        val message = error.message ?: error.toString()
        emit(LoginActionState.Failure(message))
    }
}
