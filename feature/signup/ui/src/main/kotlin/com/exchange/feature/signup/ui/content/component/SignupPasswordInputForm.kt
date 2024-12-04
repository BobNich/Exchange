package com.exchange.feature.signup.ui.content.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import com.exchange.designsystem.components.input.PasswordInputForm
import com.exchange.feature.signup.ui.R
import com.exchange.feature.signup.ui.interactor.password.PasswordUiState


@Composable
fun SignupPasswordInputForm(
    uiState: PasswordUiState,
    onTextChanged: (String) -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    PasswordInputForm(
        modifier = modifier,
        text = uiState.text,
        onTextChanged = onTextChanged,
        enabled = enabled,
        hint = stringResource(
            id = R.string.signup_password_input_hint
        )
    )
}
