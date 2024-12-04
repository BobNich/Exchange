package com.exchange.feature.signup.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.exchange.feature.signup.ui.content.SignupScreenContent


@Composable
fun SignupRoute(
    viewModel: SignupViewModel,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel
        .uiState()
        .collectAsStateWithLifecycle()

    val usernameUiState by viewModel
        .usernameUiState()
        .collectAsStateWithLifecycle()

    val passwordUiState by viewModel
        .passwordUiState()
        .collectAsStateWithLifecycle()

    SignupScreenContent(
        modifier = modifier,
        uiState = uiState,
        usernameUiState = usernameUiState,
        passwordUiState = passwordUiState,
        onBackClicked = navigateBack,
        onUsernameChanged = { username ->
            viewModel.updateUsername(username)
        },
        onPasswordChanged = { password ->
            viewModel.updatePassword(password)
        },
        onSignUpClicked = {
            viewModel.signup(
                username = usernameUiState.text,
                password = passwordUiState.text
            )
        }
    )
}
