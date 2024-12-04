package com.exchange.feature.signup.ui.interactor.password


interface PasswordUiState {

    val text: String

    data object Initial : PasswordUiState {
        override val text = ""
    }

    data class SuccessValidation(
        override val text: String
    ) : PasswordUiState
}
