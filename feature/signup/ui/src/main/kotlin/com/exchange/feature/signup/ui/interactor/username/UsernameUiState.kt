package com.exchange.feature.signup.ui.interactor.username


interface UsernameUiState {

    val text: String

    data object Initial : UsernameUiState {
        override val text = ""
    }

    data class SuccessValidation(
        override val text: String
    ) : UsernameUiState
}
