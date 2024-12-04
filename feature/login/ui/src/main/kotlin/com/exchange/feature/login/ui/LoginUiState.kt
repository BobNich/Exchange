package com.exchange.feature.login.ui

sealed interface LoginUiState {
    data object Initial : LoginUiState

    data object Loading : LoginUiState

    data object Success : LoginUiState

    data class Failure(
        val message: String
    ) : LoginUiState
}