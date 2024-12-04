package com.exchange.feature.login.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.login.ui.LoginUiState
import com.exchange.feature.login.ui.content.component.DontHaveAnAccountTextAnimation
import com.exchange.feature.login.ui.content.component.LoginPasswordInputForm
import com.exchange.feature.login.ui.content.component.SignInButton
import com.exchange.feature.login.ui.content.component.Title
import com.exchange.feature.login.ui.content.component.UsernameInputForm
import com.exchange.feature.login.ui.interactor.password.PasswordUiState
import com.exchange.feature.login.ui.interactor.username.UsernameUiState


@Composable
fun LoginScreenContent(
    uiState: LoginUiState,
    usernameUiState: UsernameUiState,
    passwordUiState: PasswordUiState,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isLoading = uiState is LoginUiState.Loading
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Title(
                modifier = Modifier
                    .padding(start = 20.dp)
            )
            UsernameInputForm(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 24.dp
                    ),
                uiState = usernameUiState,
                enabled = !isLoading,
                onTextChanged = onUsernameChanged,
            )
            LoginPasswordInputForm(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 24.dp
                    ),
                uiState = passwordUiState,
                enabled = !isLoading,
                onTextChanged = onPasswordChanged,
            )
            SignInButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 24.dp
                    ),
                onClick = onSignInClicked,
                loading = isLoading
            )
        }
        DontHaveAnAccountTextAnimation(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            visible = !isLoading,
            onSignUpClicked = onSignUpClicked
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewLoginScreenContent() {
    ApplicationTheme {
        LoginScreenContent(
            uiState = LoginUiState.Initial,
            usernameUiState = UsernameUiState.Initial,
            passwordUiState = PasswordUiState.Initial,
            onUsernameChanged = {},
            onPasswordChanged = {},
            onSignInClicked = {},
            onSignUpClicked = {}
        )
    }
}
