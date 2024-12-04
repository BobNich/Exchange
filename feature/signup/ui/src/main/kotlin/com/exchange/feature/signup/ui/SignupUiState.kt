package com.exchange.feature.signup.ui


sealed interface SignupUiState {
    data object Initial : SignupUiState

    data object Loading : SignupUiState

    data object Success : SignupUiState

    data class Failure(
        val message: String
    ) : SignupUiState
}