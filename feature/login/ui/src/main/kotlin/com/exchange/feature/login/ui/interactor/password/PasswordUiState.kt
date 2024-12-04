package com.exchange.feature.login.ui.interactor.password

interface PasswordUiState {

    val text: String

    data object Initial : PasswordUiState {
        override val text = ""
    }

    data class SuccessValidation(
        override val text: String
    ) : PasswordUiState

    data class FailureValidation(
        val message: String,
        override val text: String
    ) : PasswordUiState
}