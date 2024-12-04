package com.exchange.feature.login.ui.interactor.username

interface UsernameUiState {

    val text: String

    data object Initial : UsernameUiState {
        override val text = ""
    }

    data class SuccessValidation(
        override val text: String
    ) : UsernameUiState

    data class FailureValidation(
        val message: String,
        override val text: String
    ) : UsernameUiState
}