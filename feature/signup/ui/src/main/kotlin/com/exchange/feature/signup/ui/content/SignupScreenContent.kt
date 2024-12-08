package com.exchange.feature.signup.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.exchange.designsystem.theme.ApplicationTheme
import com.exchange.feature.signup.ui.SignupUiState
import com.exchange.feature.signup.ui.interactor.username.UsernameUiState
import com.exchange.feature.signup.ui.content.component.Header
import com.exchange.feature.signup.ui.content.component.SignupPasswordInputForm
import com.exchange.feature.signup.ui.content.component.SignUpButton
import com.exchange.feature.signup.ui.content.component.Title
import com.exchange.feature.signup.ui.content.component.UsernameInputForm
import com.exchange.feature.signup.ui.interactor.password.PasswordUiState


@Composable
fun SignupScreenContent(
    uiState: SignupUiState,
    usernameUiState: UsernameUiState,
    passwordUiState: PasswordUiState,
    onBackClicked: () -> Unit,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isLoading = uiState is SignupUiState.Loading
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Header(
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp
                ),
            onClick = onBackClicked
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Title(
                modifier = Modifier.padding(start = 20.dp)
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
                onTextChanged = onUsernameChanged,
                enabled = !isLoading
            )
            SignupPasswordInputForm(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 24.dp
                    ),
                uiState = passwordUiState,
                onTextChanged = onPasswordChanged,
                enabled = !isLoading
            )
            SignUpButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 24.dp
                    ),
                onClick = onSignUpClicked,
                loading = isLoading
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewLoginScreenContent() {
    ApplicationTheme {
        SignupScreenContent(
            uiState = SignupUiState.Initial,
            usernameUiState = UsernameUiState.Initial,
            passwordUiState = PasswordUiState.Initial,
            onBackClicked = {},
            onUsernameChanged = {},
            onPasswordChanged = {},
            onSignUpClicked = {}
        )
    }
}
