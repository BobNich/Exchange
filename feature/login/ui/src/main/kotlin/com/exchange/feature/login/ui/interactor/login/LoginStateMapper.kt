package com.exchange.feature.login.ui.interactor.login

import com.exchange.feature.login.domain.LoginActionState
import com.exchange.feature.login.ui.LoginUiState
import javax.inject.Inject


class LoginStateMapper @Inject constructor(
) : LoginActionState.Mapper<LoginUiState> {
    override fun progress(): LoginUiState {
        return LoginUiState.Loading
    }

    override fun success(): LoginUiState {
        return LoginUiState.Success
    }

    override fun failure(message: String): LoginUiState {
        return LoginUiState.Failure(
            message = message
        )
    }
}
