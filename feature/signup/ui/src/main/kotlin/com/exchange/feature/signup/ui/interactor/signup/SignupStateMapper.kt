package com.exchange.feature.signup.ui.interactor.signup

import com.exchange.feature.signup.domain.SignupActionState
import com.exchange.feature.signup.ui.SignupUiState
import javax.inject.Inject


class SignupStateMapper @Inject constructor(
) : SignupActionState.Mapper<SignupUiState> {
    override fun progress(): SignupUiState {
        return SignupUiState.Loading
    }

    override fun success(): SignupUiState {
        return SignupUiState.Success
    }

    override fun failure(message: String): SignupUiState {
        return SignupUiState.Failure(
            message = message
        )
    }
}
