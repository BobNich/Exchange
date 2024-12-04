package com.exchange.feature.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import com.exchange.feature.login.ui.content.LoginScreenContent


@Composable
fun LoginRoute(
    viewModel: LoginViewModel,
    navigateToSignUp: () -> Unit,
    navigateToWallet: () -> Unit,
    onShowSnackbar: (String) -> Unit,
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

    LoginScreenContent(
        uiState = uiState,
        usernameUiState = usernameUiState,
        passwordUiState = passwordUiState,
        onUsernameChanged = { username ->
            viewModel.updateUsername(username)
        },
        onPasswordChanged = { password ->
            viewModel.updatePassword(password)
        },
        onSignInClicked = {
            viewModel.login(
                username = usernameUiState.text,
                password = passwordUiState.text
            )
        },
        onSignUpClicked = navigateToSignUp,
        modifier = modifier
    )
}
